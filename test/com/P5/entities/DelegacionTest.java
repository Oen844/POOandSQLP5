package com.P5.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelegacionTest {

    @Test
    void getId() {
        Delegacion delegacion = new Delegacion(1,"Barcelona","609875485","entreculturas@gmail.com", "akksjadkjsd",true);
        int resultado = delegacion.getId();
        int esperado = 1;
        assertEquals(resultado,esperado);
    }

    @Test
    void getCiudad() {
        Delegacion delegacion = new Delegacion(1,"Barcelona","609875485","entreculturas@gmail.com", "akksjadkjsd",true);
        String resultado = delegacion.getCiudad();
        String esperado = "Barcelona";
        assertEquals(esperado,resultado);
    }

    @Test
    void getCentral() {
    }
}