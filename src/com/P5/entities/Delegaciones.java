package com.P5.entities;

import java.util.ArrayList;

public class Delegaciones {
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private boolean central;


    public Delegaciones(String ciudad, String direccion, String telefono, String email, boolean central) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.central = central;

        if(central = true){         //si es una central se crean un array con las diferentes listas.
            ArrayList<Proyectos>proyectos = new ArrayList;
            ArrayList<Personal>personal = new ArrayList;
            ArrayList<Aportaciones>aportaciones = new ArrayList;
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCentral() {
        return central;
    }

    public void setCentral(boolean central) {
        this.central = central;
    }
}
