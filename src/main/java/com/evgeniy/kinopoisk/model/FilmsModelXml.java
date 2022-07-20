package com.evgeniy.kinopoisk.model;


import lombok.Data;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Data
@XmlRootElement(name = "films")
public class FilmsModelXml {
    private List<FilmsModel> filmsModelXml;
}
