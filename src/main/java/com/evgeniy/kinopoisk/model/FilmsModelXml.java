package com.evgeniy.kinopoisk.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "films")

public class FilmsModelXml {

    private List<FilmsModel> filmsModelXml = new ArrayList<>();

    @XmlElement(name = "Film")
    public List<FilmsModel> getFilmsModelXml() {
        return filmsModelXml;
    }

    public void setFilmsModelXml(List<FilmsModel> filmsModelXml) {
        this.filmsModelXml = filmsModelXml;
    }
}
