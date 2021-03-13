package com.P5.entities;

public class Personal {
    private int idPersona;
    private String nombre;
    private String Nif;
    private String direccion;

    //Constructor
    public Personal(int idPersona, String nombre, String nif, String direccion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        Nif = nif;
        this.direccion = direccion;
    }

    //getters ans setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return Nif;
    }

    public void setNif(String nif) {
        Nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
