package com.P5.DAO;

import com.P5.DAO.interfaces.IDelegacion;
import com.P5.DAO.interfaces.IPersonal;
import com.P5.DAO.interfaces.IProyecto;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DAOFactory {

    public static IDelegacion getDelegacionDAO(boolean xml) throws ParserConfigurationException, SAXException, IOException {
        if (xml) {
            return new DelegacionImpl();
        } else {
            return new DelegacionImpl();
        }
    }

    public static IPersonal getPersonalDAO(boolean xml) throws ParserConfigurationException, SAXException, IOException {
        if (xml) {
            return new PersonalImpl();
        } else {
            return new PersonalImpl();
        }
    }

    public static IProyecto getProyectoDAO(boolean xml) throws ParserConfigurationException, SAXException, IOException {
        if (xml) {
            return new ProyectoImpl();
        } else {
            return new ProyectoImpl();
        }
    }
}
