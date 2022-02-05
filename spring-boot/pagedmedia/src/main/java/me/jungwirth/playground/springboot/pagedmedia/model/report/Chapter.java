package me.jungwirth.playground.springboot.pagedmedia.model.report;

import java.util.List;

import me.jungwirth.playground.springboot.pagedmedia.model.data.ELadestelle;

public class Chapter {

    private String title;

    private Long bezirk;

    private List<ELadestelle> ladestellen;

    // getter and setter 
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public Long getBezirk() {
        return bezirk;
    }

    public void setBezirk(Long bezirk) {
        this.bezirk = bezirk;
    }

    public List<ELadestelle> getLadestellen() {
        return ladestellen;
    }

    public void setLadestellen(List<ELadestelle> ladestellen) {
        this.ladestellen = ladestellen;
    }
    
}
