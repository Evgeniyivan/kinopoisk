package com.evgeniy.kinopoisk.client;


import com.evgeniy.kinopoisk.model.KinopoiskDtoFilter;
import com.evgeniy.kinopoisk.model.KinopoiskFilm;
import java.util.List;

public interface KinopoiskClient {
    List<KinopoiskFilm> getFilms(KinopoiskDtoFilter filter);
    String generateUrl(KinopoiskDtoFilter filter);

}
