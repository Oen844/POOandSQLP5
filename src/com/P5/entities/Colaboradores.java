package com.P5.entities;

public class Colaboradores extends Personal{

    private String areaColaboracion;

    public Colaboradores(int idPersona, String nombre, String nif, String direccion, String areaColaboracion) {
        super(idPersona, nombre, nif, direccion);
        this.areaColaboracion = areaColaboracion;
    }

    public String getAreaColaboracion() {
        return areaColaboracion;
    }

    public void setAreaColaboracion(String areaColaboracion) {
        this.areaColaboracion = areaColaboracion;
    }
}
