package com.evgeniy.kinopoisk.service;

import com.evgeniy.kinopoisk.client.KinopoiskClient;
import com.evgeniy.kinopoisk.mapper.FilmMapper;
import com.evgeniy.kinopoisk.model.FilmsModel;
import com.evgeniy.kinopoisk.model.KinopoiskDbFilter;
import com.evgeniy.kinopoisk.model.KinopoiskDtoFilter;
import com.evgeniy.kinopoisk.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KinopoiskServiceImpl implements KinopoiskIService {
    private final KinopoiskClient kinopoiskClient;
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<FilmsModel> findAllDb() {
        return filmRepository.findAll();
    }

    @Override
    public List<FilmsModel> findAll(KinopoiskDtoFilter filter) {
        return kinopoiskClient.getFilms(filter).stream()
                .map(filmMapper::toFilm)
                .collect(Collectors.toList());
    }

    @Override
    public List<FilmsModel> getFilmsFromDb(KinopoiskDbFilter filter) {
        if(filter == null) {
            return null;
        }
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FilmsModel> cq = cb.createQuery(FilmsModel.class);

        Root<FilmsModel> films = cq.from(FilmsModel.class);

        Path<Integer> kinopoiskId = films.get("kinopoiskId");

        Path<String> nameRu = films.get("nameRu");

        Path<String> nameOriginal = films.get("nameOriginal");

        Path<Integer> year = films.get("year");

        Path<Integer> ratingKinopoisk = films.get("ratingKinopoisk");

        Path<Integer> ratingImdb = films.get("ratingImdb");


        List<Predicate> predicateList = new ArrayList<>();

        if(filter.getKinopoiskId() != null) {
            predicateList.add(cb.in(kinopoiskId));
        }
        if(filter.getNameRu() != null) {
            predicateList.add(cb.in(nameRu));
        }

        if (filter.getNameOriginal() != null) {
            predicateList.add(cb.in(nameOriginal));
        }

        if (filter.getYear() != null) {
            predicateList.add(cb.in(year));
        }

        if (filter.getRatingKinopoisk() != null) {
            predicateList.add(cb.in(ratingKinopoisk));
        }

        if (filter.getRatingImdb() != null) {
            predicateList.add(cb.in(ratingImdb));
        }


        cq.where(predicateList.toArray(new Predicate[0]));
        TypedQuery<FilmsModel> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<FilmsModel> addFilm(KinopoiskDtoFilter filter) {
        return kinopoiskClient.getFilms(filter).stream()
                .map(filmMapper::toFilm)
                .peek(this::saveFromDb)
                .collect(Collectors.toList());
    }


    @Override
    public void saveFromDb(FilmsModel film) {
        if (!filmRepository.existsByKinopoiskId(film.getKinopoiskId())) {
            filmRepository.save(film);
        }
    }
}
