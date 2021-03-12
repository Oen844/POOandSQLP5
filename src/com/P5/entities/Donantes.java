package com.P5.entities;

public class Donantes {

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String cuentaBancacia;

    public Donantes(String nombre, String apellido, String dni, String direccion, String cuentaBancacia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.cuentaBancacia = cuentaBancacia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuentaBancacia() {
        return cuentaBancacia;
    }

    public void setCuentaBancacia(String cuentaBancacia) {
        this.cuentaBancacia = cuentaBancacia;
    }
}
