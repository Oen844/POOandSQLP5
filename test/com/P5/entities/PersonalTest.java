package com.P5.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTest {

    @Test
    void setIdPersona() {
        Personal personal = new Personal(1,"Pau","4254654654654", "calle falsa");

        int esperado = 1;
        int real = personal.getIdPersona();
        Assertions.assertEquals(esperado, real);
    }


}