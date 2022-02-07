package me.jungwirth.playground.springboot.pdf.pagedmedia.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import me.jungwirth.playground.springboot.pdf.pagedmedia.model.data.ELadestelle;
import me.jungwirth.playground.springboot.pdf.pagedmedia.model.data.FeatureCollection;
import me.jungwirth.playground.springboot.pdf.pagedmedia.model.report.Chapter;
import me.jungwirth.playground.springboot.pdf.pagedmedia.model.report.IndexEntry;

/**
 * 
 * @author Bernhard Jungwirth
 * 
 */
@Service
public class OpenDataService {
    
    /**
     * open ELadestelle json file and transform json object to java objects
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public List<ELadestelle> getELadeStelleData() throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File dataFile = ResourceUtils.getFile("classpath:data/ELADESTELLEOGD.json");

        FeatureCollection collection = mapper.readValue(dataFile, FeatureCollection.class);

        return collection.getFeatures().stream().map(f -> f.getProperties()).collect(Collectors.toList());        
        
    }

    /**
     * group loading point list by district 
     * @param loadingPoints
     * @return
     */
    public Map<Long, List<ELadestelle>> groupLoadingPointByDistrict(List<ELadestelle> loadingPoints) {
        Map<Long, List<ELadestelle>> ladestellePerBezirk = 
        loadingPoints.stream()
            .filter(l -> l.getBezirk() != null)
            .collect(Collectors.groupingBy(ELadestelle::getBezirk));

        return ladestellePerBezirk;

    }


    /**
     * generate map object for report template with data from loading points
     * @return
     */
    public Map<String,Object> generateValuesForReport() {
        Map<String,Object> values = new HashMap<>();
        List<Chapter> chapters = new ArrayList<>();
        List<IndexEntry> indexEntries = new ArrayList<>();

        values.put("title", "E-Ladestellen in Wien");
        values.put("chapters", chapters);
        values.put("index", indexEntries);
        List<ELadestelle> loadingPoints;
        try {
            loadingPoints = getELadeStelleData();
            Map<Long, List<ELadestelle>> loadingPointsForDistrict = groupLoadingPointByDistrict(loadingPoints);

            for(var entry : loadingPointsForDistrict.entrySet()) {
                Chapter c = new Chapter();
                IndexEntry index = new IndexEntry();
                String title = "Ladestellen im "+entry.getKey()+". Bezirk";

                c.setBezirk(entry.getKey());
                c.setTitle(title);
                c.setLadestellen(entry.getValue());
                chapters.add(c);
                index.setTitle(title);
                index.setTarget(entry.getKey().toString());
                indexEntries.add(index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }



}
