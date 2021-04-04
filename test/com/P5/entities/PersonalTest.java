package com.P5.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTest {

    @Test
    void setIdPersona() {
        Personal personal = new Personal();
        personal.setIdPersona(25);
        int esperado = 25;
        int real = personal.getIdPersona();
        Assertions.assertEquals(esperado, real);
    }


}