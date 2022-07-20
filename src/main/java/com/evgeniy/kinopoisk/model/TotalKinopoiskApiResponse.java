package com.evgeniy.kinopoisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalKinopoiskApiResponse {
    private Integer total;
    private Integer totalPages;
    private List<KinopoiskFilm> items;
}
