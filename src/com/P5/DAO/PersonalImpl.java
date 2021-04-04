package com.P5.DAO;

import com.P5.DAO.interfaces.IPersonal;
import com.P5.entities.Personal;
import com.P5.xml.XMLManager;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class PersonalImpl implements IPersonal {

    XMLManager xmlFactory = new XMLManager();

    public PersonalImpl() throws IOException, SAXException, ParserConfigurationException {
    }

    @Override
    public List<Personal> findPersonalDelegacion() {
        return null;
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
