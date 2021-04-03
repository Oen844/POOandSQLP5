package com.P5.DAO;

import com.P5.DAO.interfaces.IProyecto;
import com.P5.DTO.ProyectoDTO;
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
import java.text.SimpleDateFormat;
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
    public Proyecto readProyecto(String nombre) {
        try {
            NodeList proyectos = this.xmlFactory.recuperarElemento("proyecto");
            for (int i = 0; i < proyectos.getLength(); i++) {
                Element delegacionXML = (Element) proyectos.item(i);
                Node delegacionProyecto = this.xmlFactory.recuperarElementoEnElemento("nombre", delegacionXML);
                if (delegacionProyecto.getTextContent().equals(nombre)) {
                    return ProyectoDTO.toEntity(delegacionXML);
                }
            }
        } catch (ParserConfigurationException | SAXException | ParseException | IOException e) {
            System.out.println(e.getMessage());
        }

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        NodeList proyectos = this.xmlFactory.recuperarElemento("proyecto");
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element proyectoXml = (Element) proyectos.item(i);
            Node nombreNodeXml = this.xmlFactory.recuperarElementoEnElemento("nombre", proyectoXml);
            if (proyectoXml.getElementsByTagName("nombre").item(0).getTextContent().equals(nombreNodeXml.getTextContent())) {
                proyectoXml.getElementsByTagName("pais").item(0).setTextContent(proyecto.getPais());
                proyectoXml.getElementsByTagName("localizacion").item(0).setTextContent(proyecto.getLocalizacion());
                proyectoXml.getElementsByTagName("lineaAccion").item(0).setTextContent(proyecto.getLineaAccion());
                proyectoXml.getElementsByTagName("fechaInicio").item(0).setTextContent(dateFormat.format(proyecto.getFechaInicio()));
                proyectoXml.getElementsByTagName("fechaFin").item(0).setTextContent(dateFormat.format(proyecto.getFechaFin()));
                proyectoXml.getElementsByTagName("socioLocal").item(0).setTextContent(proyecto.getSocioLocal());
                proyectoXml.getElementsByTagName("financiador").item(0).setTextContent(proyecto.getFinanciador());
                proyectoXml.getElementsByTagName("financiacionAportada").item(0).setTextContent(proyecto.getFinanciacionAportada());

                try {
                    this.xmlFactory.eliminarElemento("proyectos`", "proyecto`", proyecto.getNombre());
                    this.xmlFactory.anhadirElemento("proyectos", proyectoXml);
                } catch (TransformerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return proyecto;
    }

    @Override
    public void deleteProyecto(String nombre) {
        NodeList proyectos = this.xmlFactory.recuperarElemento("proyecto");
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element proyectoXML = (Element) proyectos.item(i);
            Node nombreNodeXml = this.xmlFactory.recuperarElementoEnElemento("nombre", proyectoXML);
            if (proyectoXML.getElementsByTagName("nombre").item(0).getTextContent().equals(nombreNodeXml.getTextContent())) {
                try {
                    this.xmlFactory.eliminarElemento("proyectos", "proyecto", nombre);
                } catch (TransformerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
