package com.P5.DAO;

import com.P5.DAO.interfaces.IDelegacion;
import com.P5.DAO.interfaces.IPersonal;
import com.P5.DAO.interfaces.IProyecto;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.P5.main.Main.connection;

public class DAOFactory {

    public static IDelegacion getDelegacionDAO(boolean xml) throws ParserConfigurationException, SAXException, IOException {
        if (xml) {
            return new DelegacionXMLImpl();
        } else {
            return new DelegacionXMLImpl();
        }
    }

    public static IPersonal getPersonalDAO(boolean xml) throws ParserConfigurationException, SAXException, IOException {
        if (xml) {
            return new PersonalXMLImpl();
        } else {
            return new PersonalXMLImpl();
        }
    }

    public static IProyecto getProyectoDAO(boolean xml) throws ParserConfigurationException, SAXException, IOException {
        if (xml) {
            return new ProyectoXMLImpl();
        } else {
            return new ProyectoXMLImpl();
        }
    }
}
