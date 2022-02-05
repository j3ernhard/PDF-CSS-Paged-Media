package me.jungwirth.playground.springboot.pagedmedia.model.data;

import java.util.List;

public class FeatureCollection {
    
    private Long totalFeatures;

    private List<Feature> features;

    
    public Long getTotalFeatures() {
        return totalFeatures;
    }

    public void setTotalFeatures(Long totalFeatures) {
        this.totalFeatures = totalFeatures;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
