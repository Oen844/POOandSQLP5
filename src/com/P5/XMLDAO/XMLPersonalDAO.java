package com.P5.XMLDAO;

import com.P5.DAO.interfaces.IPersonal;
import com.P5.entities.Personal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.util.List;

public class XMLPersonalDAO implements IPersonal {

    JAXBContext context = JAXBContext.newInstance(Personal.class);
    Marshaller marshaller = context.createMarshaller();


    @Override
    public void insertar(Personal a) {
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(Personal, new FileWriter("Personal.xml"));


    }

    @Override
    public void modificar(Personal a) {

    }

    @Override
    public void eliminar(Personal a) {

    }

    @Override
    public List<Personal> obtenerTodos() {
        return null;
    }

    @Override
    public Personal obtener(int id) {
        return null;
    }
}
