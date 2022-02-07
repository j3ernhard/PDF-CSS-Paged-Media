package me.jungwirth.playground.springboot.pdf.pagedmedia.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.jungwirth.playground.springboot.pdf.pagedmedia.model.report.Chapter;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PdfGenerationServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfGenerationServiceTest.class);

    private static final Path path = Paths.get("C:\\Users\\Bernhard\\Development\\PDFGeneration\\PrinceXML");

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @Autowired
    private OpenDataService openDataService;


    @Test
    public void testProcessHtmlTemplate() {
        String htmlResult = pdfGenerationService.processHtmlTemplate(getValues());
        assertNotNull(htmlResult, "html result not created");
        System.out.println(htmlResult);
    }

    @Test
    public void testGeneratePdfFile() {

        try {
            Path htmlFile = Files.createTempFile(path, "html", ".html");
            Files.write(htmlFile, "<html><body><h1>test</h1></body></html>".getBytes());

            Path pdfPath = Files.createTempFile(path, "pdf", ".pdf");

            boolean result = pdfGenerationService.generatePdf(htmlFile.toString(), pdfPath.toString());
            LOGGER.info("PDF Result {} {}",result, pdfPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGeneratePdfWithTestData() {

      
        String htmlResult = pdfGenerationService.processHtmlTemplate(getValues());

        try {
            
            Path htmlFile = Files.createTempFile(path, "html", ".html");
            Files.write(htmlFile, htmlResult.getBytes());
            Path pdfPath = Files.createTempFile(path, "pdf", ".pdf");

            boolean result = pdfGenerationService.generatePdf(htmlFile.toString(), pdfPath.toString());
            LOGGER.info("PDF Result {} {}",result, pdfPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGeneratePdfWithOpenData() {
        String htmlResult = pdfGenerationService.processHtmlTemplate(openDataService.generateValuesForReport());

        try {
            
            Path htmlFile = Files.createTempFile(path, "html", ".html");
            Files.write(htmlFile, htmlResult.getBytes());
            Path pdfPath = Files.createTempFile(path, "pdf", ".pdf");

            boolean result = pdfGenerationService.generatePdf(htmlFile.toString(), pdfPath.toString());
            LOGGER.info("PDF Result {} {}",result, pdfPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * generate report values for test
     * @return
     */
    private Map<String,Object> getValues() {
        Map<String,Object> values = new HashMap<>();

        List<Chapter> chapters = new ArrayList<>();

        Chapter chapter1 = new Chapter();
        chapter1.setTitle("Kapitel 1");
        chapter1.setLadestellen(Collections.emptyList());

        chapters.add(chapter1);

        values.put("title", "Open Data Report");
        values.put("chapters", chapters);
        return values;

    }
  
}
