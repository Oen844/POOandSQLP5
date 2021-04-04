package com.P5.Test;

import com.P5.entities.Delegacion;
import com.P5.entities.Personal;
import com.P5.entities.Proyecto;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void getNombre() throws ParseException {
        ArrayList<Personal> trabajadores = new ArrayList<Personal>();
        Date fecha1 = new Date(10/10/2021);
        Date fecha2 = new Date(10/11/2021);
        String fechaInicio = "10/10/2021";
        String fechaFin = "11/10/2021";
        Date fechaInicioDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaInicio);
        Date fechaFinDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaFin);

        Delegacion delegacion = new Delegacion(1,"Barcelona","609875485","entreculturas@gmail.com", "akksjadkjsd",true);
        Personal personal = new Personal(1,"Pau","4254654654654", "calle falsa",delegacion);
        trabajadores.add(personal);
        Proyecto proyecto = new Proyecto("pisos","españa","Muercia","casas","vive",fechaInicioDate,fechaFinDate,"casdasdad","asdasdasd","asasdasd",trabajadores,delegacion);
        String resultado = proyecto.getNombre();
        String esperado = "pisos";
        assertEquals(resultado,esperado);

    }

    @Test
    void getPais() throws ParseException {
        ArrayList<Personal> trabajadores = new ArrayList<Personal>();
        Date fecha1 = new Date(10/10/2021);
        Date fecha2 = new Date(10/11/2021);
        String fechaInicio = "10/10/2021";
        String fechaFin = "11/10/2021";
        Date fechaInicioDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaInicio);
        Date fechaFinDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaFin);

        Delegacion delegacion = new Delegacion(1,"Barcelona","609875485","entreculturas@gmail.com", "akksjadkjsd",true);
        Personal personal = new Personal(1,"Pau","4254654654654", "calle falsa",delegacion);
        trabajadores.add(personal);
        Proyecto proyecto = new Proyecto("pisos","españa","Muercia","casas","vive",fechaInicioDate,fechaFinDate,"casdasdad","asdasdasd","asasdasd",trabajadores,delegacion);
        String resultado = proyecto.getPais();
        String esperado = "españa";
        assertEquals(resultado,esperado);
    }
}