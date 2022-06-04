package com.evgeniy.kinopoisk.sender;

import javax.mail.MessagingException;

public interface EmailSender {
    void EmailSend() throws MessagingException;
}
