package com.evgeniy.kinopoisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KinopoiskDtoFilter {
    private List<Integer> countries;
    private List<Integer> genres;
    private KinoFilterSort order;
    private KinoType type;
    private Integer ratingFrom;
    private Integer ratingTo;
    private Integer yearFrom;
    private Integer yearTo;
    private Integer page;
    private String keyword;
}
