package com.manish.clientexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@SpringBootApplication
public class ClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientExampleApplication.class, args);
	}

}

@RestController
@RequestMapping("/call")
class ServiceCallerController {


	private final XmlMarshaller xmlMarshaller;
	private final XmlUnmarshaller xmlUnmarshaller;

	ServiceCallerController(XmlMarshaller xmlMarshaller, XmlUnmarshaller xmlUnmarshaller) {
		this.xmlMarshaller = xmlMarshaller;
		this.xmlUnmarshaller = xmlUnmarshaller;
	}

	@GetMapping
	public void callServices() {

		try {
			xmlMarshaller.objectToXml();
			xmlUnmarshaller.xmlToObject();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
