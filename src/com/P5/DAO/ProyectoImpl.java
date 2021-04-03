package com.P5.DAO;

import com.P5.DAO.interfaces.IProyecto;
import com.P5.entities.Proyecto;
import com.P5.xml.XMLManager;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class ProyectoImpl implements IProyecto {

    XMLManager xmlFactory = new XMLManager();

    public ProyectoImpl() throws IOException, SAXException, ParserConfigurationException {
    }

    @Override
    public List<Proyecto> findProyectosDelegacion(String delgacionId) {
        return null;
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
