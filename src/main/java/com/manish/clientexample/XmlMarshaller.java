package com.manish.clientexample;

import lombok.extern.slf4j.Slf4j;
import mypackage.Book;
import mypackage.Bookstore;
import mypackage.Title;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

@Component
@Slf4j
public class XmlMarshaller {

    public void objectToXml() throws JAXBException, FileNotFoundException {
        log.info("Calling Object To Xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Bookstore bookstore = Bookstore
                .builder()
                .book(Arrays.asList(Book
                        .builder()
                        .title(Title
                                .builder()
                                .content("sci-fi")
                                .lang("ENG")
                                .build())
                        .build(), Book
                        .builder()
                        .title(Title
                                .builder()
                                .content("self-help")
                                .lang("HINDI")
                                .build())
                        .build()))
                .build();

        Bookstore bookstore1 = Bookstore
                .builder()
                .book(Arrays.asList(Book
                        .builder()
                        .title(Title
                                .builder()
                                .content("Biography")
                                .lang("Parsian")
                                .build())
                        .build(), Book
                        .builder()
                        .title(Title
                                .builder()
                                .content("Course")
                                .lang("ENGLISH")
                                .build())
                        .build()))
                .build();
        marshaller.marshal(bookstore, new File("BookStore_Created.xml"));
        marshaller.marshal(bookstore1, new File("BookStore1_Created.xml"));
    }
}
