package me.jungwirth.playground.springboot.pagedmedia.model.data;

public class Feature {

    private String id;

    private String type;

    private ELadestelle properties;

    private Geometry geometry;

    private String geometry_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ELadestelle getProperties() {
        return properties;
    }

    public void setProperties(ELadestelle properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    
    public String getGeometry_name() {
        return geometry_name;
    }

    public void setGeometry_name(String geometry_name) {
        this.geometry_name = geometry_name;
    }
    
    
    
}
