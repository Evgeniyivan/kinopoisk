package com.evgeniy.kinopoisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KinopoiskFilm {
    private Long kinopoiskId;
    private String nameRu;
    private String nameOriginal;
    private Integer year;
    private Integer ratingKinopoisk;
    private Integer ratingImdb;
}
