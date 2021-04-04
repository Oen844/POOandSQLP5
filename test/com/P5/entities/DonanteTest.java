package com.P5.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DonanteTest {

    @Test
    void setNombre() {
        Donante donante = new Donante();
        donante.setNombre("Pau");
        String esperado = "Pau";
        String real = donante.getNombre();
        Assertions.assertEquals(esperado, real);
    }

    @Test
    void setApellido() {
        Donante donante = new Donante();
        donante.setApellido("Egea");
        String esperado = "Egea";
        String real = donante.getApellido();
        Assertions.assertEquals(esperado, real);
    }
}