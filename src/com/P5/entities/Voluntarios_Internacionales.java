package com.P5.entities;

public class Voluntarios_Internacionales extends Voluntarios{
    private String pais;

    public Voluntarios_Internacionales(int idPersona, String nombre, String nif, String direccion, String tareaDesepena, String tipoVoluntario, String pais) {
        super(idPersona, nombre, nif, direccion, tareaDesepena, tipoVoluntario);
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
