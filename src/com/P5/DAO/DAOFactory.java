package com.P5.DAO;

import com.P5.DAO.interfaces.IDelegacion;
import com.P5.DAO.interfaces.IPersonal;
import com.P5.DAO.interfaces.IProyecto;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

import static com.P5.main.Main.connection;

public class DAOFactory {

    public static IDelegacion getDelegacionDAO() throws ParserConfigurationException, SAXException, IOException, SQLException {
        if (connection != null) {
            return new DelegacionDBImpl();
        } else {
            return new DelegacionXMLImpl();
        }
    }

    public static IPersonal getPersonalDAO() throws ParserConfigurationException, SAXException, IOException, SQLException {
        if (connection != null) {
            return new PersonalDBImpl();
        } else {
            return new PersonalXMLImpl();
        }
    }

    public static IProyecto getProyectoDAO() throws ParserConfigurationException, SAXException, IOException {
        if (connection != null) {
            return new ProyectoXMLImpl();
        } else {
            return new ProyectoXMLImpl();
        }
    }
}
