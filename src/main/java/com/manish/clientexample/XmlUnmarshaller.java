package com.manish.clientexample;

import lombok.extern.slf4j.Slf4j;
import mypackage.Bookstore;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;

@Component
@Slf4j
public class XmlUnmarshaller {

    public void xmlToObject() throws JAXBException, FileNotFoundException {
        log.info("Calling XML to Object");
        JAXBContext jaxbContext;

        try
        {
            //Get JAXBContext
            jaxbContext = JAXBContext.newInstance(Bookstore.class);

            //Create Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //Setup schema validator
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema employeeSchema = sf.newSchema(new File("BookStore.xsd"));
            jaxbUnmarshaller.setSchema(employeeSchema);

            //Unmarshal xml file
            Bookstore bookstore = (Bookstore) jaxbUnmarshaller.unmarshal(new File("BookStore.xml"));

            System.out.println(bookstore);
        }
        catch (JAXBException | SAXException e)
        {
            e.printStackTrace();
        }
    }



}