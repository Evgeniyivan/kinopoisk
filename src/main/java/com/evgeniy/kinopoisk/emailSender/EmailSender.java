package com.evgeniy.kinopoisk.emailSender;

import javax.mail.MessagingException;

public interface EmailSender {
    void emailSend() throws MessagingException;
}
