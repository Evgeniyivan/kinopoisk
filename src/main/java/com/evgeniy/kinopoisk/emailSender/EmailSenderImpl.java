package com.evgeniy.kinopoisk.emailSender;

import com.evgeniy.kinopoisk.model.FilmsModel;
import com.evgeniy.kinopoisk.model.FilmsModelXml;
import com.evgeniy.kinopoisk.service.KinopoiskIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {
    private final KinopoiskIService kinopoiskIService;
    final String USER_NAME = "email from";
    final String PASSWORD = "password";
    final String RECIPIENT = "email to";
    final String[] to = {RECIPIENT};
    final String host = "smtp.mail.ru";
    @Override
    public void emailSend() throws MessagingException {

        List<FilmsModel> filmsModelXml = kinopoiskIService.findAllDb();

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(FilmsModelXml.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File XMLfile = new File("./src/main/resources/data/exported_data.xml");

            FilmsModelXml modelFile = new FilmsModelXml();
            modelFile.setFilmsModelXml(filmsModelXml);

            jaxbMarshaller.marshal(modelFile, XMLfile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.user", USER_NAME);
        props.put("mail.smtps.starttls.enable", "true");
        props.put("mail.host", "smtp.mail.ru");

        Session session = Session.getDefaultInstance(props, null);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USER_NAME));
        message.setSentDate(new Date());

        InternetAddress[] toAddress = new InternetAddress[to.length];

        for (int i = 0; i < to.length; i++) {
            toAddress[i] = new InternetAddress(to[i]);
        }
        for (InternetAddress address : toAddress) {
            message.addRecipient(Message.RecipientType.TO, address);
        }

        message.setSubject("Фильмы кинопоиск");
        message.setText("Лови фильмы с кинопоиска");
        message.setFileName("exported_data.xml");

        Transport transport = session.getTransport("smtp");
        transport.connect(host, USER_NAME, PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
