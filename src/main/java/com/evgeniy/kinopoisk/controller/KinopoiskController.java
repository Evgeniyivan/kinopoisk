package com.evgeniy.kinopoisk.controller;


import com.evgeniy.kinopoisk.model.FilmsModel;
import com.evgeniy.kinopoisk.model.KinopoiskDbFilter;
import com.evgeniy.kinopoisk.model.KinopoiskDtoFilter;
import com.evgeniy.kinopoisk.emailSender.EmailSender;
import com.evgeniy.kinopoisk.service.KinopoiskIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class KinopoiskController {


    private final KinopoiskIService kinopoiskIService;
    private final EmailSender emailSender;

    @GetMapping("/")
    public List<FilmsModel> getFilm(KinopoiskDtoFilter filter) {
        return kinopoiskIService.findAll(filter);
    }

    @PostMapping("/")
    public List<FilmsModel> saveFilm(KinopoiskDtoFilter filter) {
        return kinopoiskIService.addFilm(filter);
    }

    @GetMapping("/fromdb")
    public List<FilmsModel> getFilmsFromDb(KinopoiskDbFilter filter) {
        return kinopoiskIService.getFilmsFromDb(filter);
    }
    @PostMapping("/mailsend")
    public void EmailSend() throws MessagingException {
        emailSender.emailSend();
    }
}
