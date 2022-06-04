package com.evgeniy.kinopoisk.mapper;



import com.evgeniy.kinopoisk.model.FilmsModel;
import com.evgeniy.kinopoisk.model.KinopoiskFilm;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface FilmMapper {
    FilmsModel toFilm(KinopoiskFilm kinopoiskFilm);

}
