package com.P5.DAO;

import com.P5.DAO.interfaces.IDelegacion;
import com.P5.DTO.DelegacionDTO;
import com.P5.entities.Delegacion;
import com.P5.xml.XMLManager;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DelegacionImpl implements IDelegacion {

    XMLManager xmlFactory = new XMLManager();

    @Override
    public List<Delegacion> findAllDelegacion() {
        List<Delegacion> delegacionesList = new ArrayList<>();
        try {
            NodeList delegaciones = this.xmlFactory.recuperarElemento("delegacion");
            for (int  i = 0; i < delegaciones.getLength(); i++) {
                Node nNode = delegaciones.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    delegacionesList.add(DelegacionDTO.toEntity(nNode));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }

        return delegacionesList;
    }

    @Override
    public void createDelegacion(Delegacion delegacion) {

    }

    @Override
    public Delegacion readDelegacion(String id) {
        return null;
    }

    @Override
    public Delegacion updateDelegacion(Delegacion delegacion) {
        return null;
    }

    @Override
    public void deleteDelegacion(String id) {

    }
}
