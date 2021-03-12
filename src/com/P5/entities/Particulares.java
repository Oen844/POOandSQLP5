package com.P5.entities;

public class Particulares extends Donantes{
    private String tipoAportacion;      //será el propia sistema el que se encargará de verificar que el tipo de dato añadido es del tipo que permitimos.


    public Particulares(String nombre, String apellido, String dni, String direccion, String cuentaBancacia, String tipoAportacion) {
        super(nombre, apellido, dni, direccion, cuentaBancacia);
        this.tipoAportacion = tipoAportacion;
    }
}
