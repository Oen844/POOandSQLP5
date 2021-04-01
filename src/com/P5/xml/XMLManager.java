package com.P5.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLManager {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    public NodeList recuperarElemento(String elementTagName) throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File("db.xml");
        DocumentBuilder dBuilder = this.dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(elementTagName);
    }
}
