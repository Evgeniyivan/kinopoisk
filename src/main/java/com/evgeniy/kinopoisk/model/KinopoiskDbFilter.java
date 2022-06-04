package com.evgeniy.kinopoisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KinopoiskDbFilter {

    private List<Long> kinopoiskId;

    private List<String> nameRu;

    private YearFromTo year;

    private List<Integer> ratingKinopoisk;

    private List<Integer> ratingImdb;

    private List<String> nameOriginal;
}
