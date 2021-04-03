package com.P5.DAO;

import com.P5.DAO.interfaces.IProyecto;
import com.P5.DTO.DelegacionDTO;
import com.P5.DTO.ProyectoDTO;
import com.P5.entities.Delegacion;
import com.P5.entities.Proyecto;
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

public class ProyectoImpl implements IProyecto {

    XMLManager xmlFactory = new XMLManager();

    public ProyectoImpl() throws IOException, SAXException, ParserConfigurationException {
    }

    @Override
    public List<Proyecto> findProyectosDelegacion(String delegacionId) {
        List<Proyecto> proyectosList = new ArrayList<>();

        try {
            NodeList proyectos = this.xmlFactory.recuperarElemento("proyecto");
            for (int i = 0; i < proyectos.getLength(); i++) {
                Node nNode = proyectos.item(i);
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

        return proyectosList;
    }

    @Override
    public Proyecto readProyecto(String id) {
        return null;
    }

    @Override
    public void createProyecto(Proyecto proyecto) {
        try {
            Element proyectoXml = this.xmlFactory.crearElementoProyecto(proyecto);
            this.xmlFactory.anhadirElemento("proyectos", proyectoXml);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Proyecto updateProyecto(Proyecto proyecto) {
        return null;
    }

    @Override
    public void deleteProyecto(String id) {

    }
}
