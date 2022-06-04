package com.evgeniy.kinopoisk.client;

import com.evgeniy.kinopoisk.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KinopoiskClientImpl implements KinopoiskClient {

    HttpHeaders httpHeaders = new HttpHeaders();

    private final RestTemplate restTemplate;

    final String URL = "https://kinopoiskapiunofficial.tech/api/v2.2/films";

    @Override
    public List<KinopoiskFilm> getFilms(KinopoiskDtoFilter filter) {

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY", "4b95e124-b726-4b46-bec7-7716cdb9ef45");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<TotalKinopoiskApiResponse> response = restTemplate.exchange(generateUrl(filter), HttpMethod.GET, httpEntity, TotalKinopoiskApiResponse.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getItems() != null) {
            return response.getBody().getItems();
        } else {
            return null;
        }

    }

    @Override
    public String generateUrl(KinopoiskDtoFilter filter) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(URL);

        Optional<KinopoiskDtoFilter> optionalFilter = Optional.ofNullable(filter);

        optionalFilter.map(KinopoiskDtoFilter::getOrder)
                .ifPresent(sort -> uriComponentsBuilder.queryParam("order", sort));

        optionalFilter.map(KinopoiskDtoFilter::getType)
                .ifPresent(type -> uriComponentsBuilder.queryParam("type", type));

        optionalFilter.map(KinopoiskDtoFilter::getCountries)
                .ifPresent(countries -> uriComponentsBuilder.queryParam("type", countries.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getGenres)
                .ifPresent(genres -> uriComponentsBuilder.queryParam("genres", genres.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getCountries)
                .ifPresent(countries -> uriComponentsBuilder.queryParam("countries", countries.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getRatingFrom)
                .ifPresent(ratingFrom -> uriComponentsBuilder.queryParam("ratingFrom", ratingFrom.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getRatingTo)
                .ifPresent(ratingTo -> uriComponentsBuilder.queryParam("ratingTo", ratingTo.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getYearFrom)
                .ifPresent(yearFrom -> uriComponentsBuilder.queryParam("yearFrom", yearFrom.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getYearTo)
                .ifPresent(yearTo -> uriComponentsBuilder.queryParam("yearTo", yearTo.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getPage)
                .ifPresent(page -> uriComponentsBuilder.queryParam("page", page.toString()));

        optionalFilter.map(KinopoiskDtoFilter::getKeyword)
                .ifPresent(keyword -> uriComponentsBuilder.queryParam("keyword", keyword));


        return uriComponentsBuilder.build().toUriString();
    }
}
