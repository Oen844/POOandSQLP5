package com.P5.DAO;

import com.P5.DAO.interfaces.IPersonal;
import com.P5.DTO.ProyectoDTO;
import com.P5.entities.Personal;
import com.P5.entities.Proyecto;
import com.P5.xml.XMLManager;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PersonalImpl implements IPersonal {

    XMLManager xmlFactory = new XMLManager();

    public PersonalImpl() throws IOException, SAXException, ParserConfigurationException {
    }

    @Override
    public List<Personal> createPersonal() {
        List<Personal> PersonalList = new ArrayList<>();
        try {
            NodeList personales = this.xmlFactory.recuperarElemento("personal");
            for (int i = 0; i < personales.getLength(); i++) {
                Node nNode = personales.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Node delegacionProyecto = this.xmlFactory.recuperarElementoEnElemento("delegacion", nNode);
                    if (delegacionProyecto.getTextContent().equals(delegacionId)) {
                        proyectosList.add(ProyectoDTO.toEntity(nNode));
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | ParseException | IOException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }

    @Override
    public Personal readPersonal(int idPersona) {


        return null;
    }

    @Override
    public void updatePersonal(Personal persona) {

    }

    @Override
    public void deletePersonal(Personal persona) {

    }
}
