package com.evgeniy.kinopoisk.service;


import com.evgeniy.kinopoisk.model.FilmsModel;
import com.evgeniy.kinopoisk.model.KinopoiskDbFilter;
import com.evgeniy.kinopoisk.model.KinopoiskDtoFilter;
import java.util.List;

public interface KinopoiskIService {
    List<FilmsModel> findAllDb();
    List<FilmsModel> findAll(KinopoiskDtoFilter filter);
    void saveFromDb(FilmsModel film);
    List<FilmsModel> addFilm(KinopoiskDtoFilter filter);
    List<FilmsModel> getFilmsFromDb(KinopoiskDbFilter filter);
}
