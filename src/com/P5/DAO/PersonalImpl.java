package com.P5.DAO;

import com.P5.DAO.interfaces.IPersonal;
import com.P5.DTO.PersonalDTO;
import com.P5.entities.Personal;
import com.P5.xml.XMLManager;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PersonalImpl implements IPersonal {

    XMLManager xmlFactory = new XMLManager();

    public PersonalImpl() throws IOException, SAXException, ParserConfigurationException {
    }

    @Override
    public List<Personal> findPersonalDelegacion(String delegacionId) {
        List<Personal> personalList = new ArrayList<>();

        try {
            NodeList personal = this.xmlFactory.recuperarElemento("personal");
            for (int i = 0; i < personal.getLength(); i++) {
                Node nNode = personal.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Node personalProyecto = this.xmlFactory.recuperarElementoEnElemento("delegacion", nNode);
                    if (personalProyecto != null && personalProyecto.getTextContent().equals(delegacionId)) {
                        personalList.add(PersonalDTO.toEntity(nNode));
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | ParseException | IOException e) {
            System.out.println(e.getMessage());
        }

        return personalList;
    }

    @Override
    public void createPersonal(Personal personal) {
        try {
            Element personalXml = this.xmlFactory.crearElementoPersonal(personal);
            this.xmlFactory.anhadirElemento("listaPersonal", personalXml);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Personal readPersonal(int idPersonal) {
        try {
            Node listaPersonal = this.xmlFactory.recuperarElemento("listaPersonal").item(0);
            NodeList personal = listaPersonal.getChildNodes();
            for (int i = 0; i < personal.getLength(); i++) {
                Node nNode = personal.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element personalXml = (Element) nNode;
                    int idPersonalXml = Integer.parseInt(personalXml.getAttribute("id"));
                    if (idPersonalXml == idPersonal) {
                        return PersonalDTO.toEntity(personalXml);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | ParseException | IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Personal updatePersonal(Personal persona) {
        return null;
    }

    @Override
    public void deletePersonal(int idPersonal) {

    }
}
