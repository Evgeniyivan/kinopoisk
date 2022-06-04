package com.evgeniy.kinopoisk.repository;

import com.evgeniy.kinopoisk.model.FilmsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FilmRepository extends JpaRepository<FilmsModel, Long> {

    boolean existsByKinopoiskId(Long kinopoiskId);

}
