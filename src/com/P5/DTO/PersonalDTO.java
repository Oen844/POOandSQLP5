package com.P5.DTO;


import com.P5.entities.Personal;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;


public class PersonalDTO {

    public static Personal toEntity(Node personalNode) throws ParseException, ParserConfigurationException, SAXException, IOException {
        Element personalXml = (Element) personalNode;
        Integer id = Integer.parseInt(personalXml.getAttribute("id"));
        String nombre = personalXml.getElementsByTagName("nombre").item(0).getTextContent();
        String nif = personalXml.getElementsByTagName("nif").item(0).getTextContent();
        String direccion = personalXml.getElementsByTagName("direccion").item(0).getTextContent();




        return new Personal(id, nombre, nif, direccion);
    }

}
