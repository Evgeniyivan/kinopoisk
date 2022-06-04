package com.evgeniy.kinopoisk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingFromTo {
    private Integer ratingFrom;
    private Integer ratingTo;
}
