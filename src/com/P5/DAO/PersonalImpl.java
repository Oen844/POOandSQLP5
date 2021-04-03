package com.P5.DAO;

import com.P5.DAO.interfaces.IPersonal;
import com.P5.entities.Personal;
import com.P5.entities.Proyecto;
import com.P5.xml.XMLManager;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonalImpl implements IPersonal {

    XMLManager xmlFactory = new XMLManager();

    public PersonalImpl() throws IOException, SAXException, ParserConfigurationException {
    }



    @Override
    public List<Personal> findPersona(Integer idPersona) {
        return null;
    }

    @Override
    public Personal readPersonal(Integer idPersona) {


        return null;
    }

    @Override
    public void updatePersonal(Personal persona) {

    }

    @Override
    public void deletePersonal(Personal persona) {

    }

    public void createPersonal(Personal persona) {
        try {
            Element personalXml = this.xmlFactory.crearElementoPersonal(persona);
            this.xmlFactory.anhadirElemento("personal", personalXml);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }


}
