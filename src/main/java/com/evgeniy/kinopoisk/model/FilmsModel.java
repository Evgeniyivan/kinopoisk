package com.evgeniy.kinopoisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class FilmsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "kinopoisk_id")
    private long kinopoiskId;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_original")
    private String nameOriginal;

    @Column(name = "year")
    private long year;

    @Column(name = "rating")
    private double ratingKinopoisk;

    @Column(name = "rating_imdb")
    private double ratingImdb;
}
