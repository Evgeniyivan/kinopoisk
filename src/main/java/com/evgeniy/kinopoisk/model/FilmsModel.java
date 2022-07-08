package com.evgeniy.kinopoisk.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class FilmsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kinopoisk_id")
    private long kinopoiskId;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_original")
    private String nameOriginal;

    @Column(name = "year")
    private long year;

    @Column(name = "rating")
    private double ratingKinopoisk;

    @Column(name = "rating_imdb")
    private double ratingImdb;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmsModel that = (FilmsModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
