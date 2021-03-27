package com.P5.entities;


public class Delegacion {
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private Delegacion delegacion;


    public Delegacion(String ciudad, String direccion, String telefono, String email, Delegacion delegacion) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.delegacion= delegacion;

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

    public Delegacion getDelegacion() { return delegacion; }

    public void setDelegacion(Delegacion delegacion) { this.delegacion = delegacion; }
}
