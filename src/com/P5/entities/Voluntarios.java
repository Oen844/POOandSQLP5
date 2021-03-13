package com.P5.entities;

public class Voluntarios extends Personal{
    private String tareaDesepena;
    private String tipoVoluntario;

    public Voluntarios(int idPersona, String nombre, String nif, String direccion, String tareaDesepena, String tipoVoluntario) {
        super(idPersona, nombre, nif, direccion);
        this.tareaDesepena = tareaDesepena;
        this.tipoVoluntario = tipoVoluntario;
    }

    public String getTareaDesepena() {
        return tareaDesepena;
    }

    public void setTareaDesepena(String tareaDesepena) {
        this.tareaDesepena = tareaDesepena;
    }

    public String getTipoVoluntario() {
        return tipoVoluntario;
    }

    public void setTipoVoluntario(String tipoVoluntario) {
        this.tipoVoluntario = tipoVoluntario;
    }
}
