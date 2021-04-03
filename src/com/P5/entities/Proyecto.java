package com.P5.entities;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {

    private String nombre;
    private String pais;
    private String localizacion;
    private String lineAccion;
    private String subLineaAccion;
    private Date fechaInicio;
    private Date fechaFin;
    private String socioLocal;
    private String financiador;
    private String financiacionAportada;
    private ArrayList<Personal> personalAsociado;
    private Delegacion delegacion;

    public Proyecto(String nombre, String pais, String localizacion, String lineAccion, String subLineaAccion, Date fechaInicio, Date fechaFin, String socioLocal, String financiador, String financiacionAportada, ArrayList<Personal> personalAsociado, Delegacion delegacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.localizacion = localizacion;
        this.lineAccion = lineAccion;
        this.subLineaAccion = subLineaAccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.socioLocal = socioLocal;
        this.financiador = financiador;
        this.financiacionAportada = financiacionAportada;
        this.personalAsociado = personalAsociado;
        this.delegacion = delegacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getLineAccion() {
        return lineAccion;
    }

    public void setLineAccion(String lineAccion) {
        this.lineAccion = lineAccion;
    }

    public String getSubLineaAccion() {
        return subLineaAccion;
    }

    public void setSubLineaAccion(String subLineaAccion) {
        this.subLineaAccion = subLineaAccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(String socioLocal) {
        this.socioLocal = socioLocal;
    }

    public String getFinanciador() {
        return financiador;
    }

    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    public String getFinanciacionAportada() {
        return financiacionAportada;
    }

    public void setFinanciacionAportada(String financiacionAportada) {
        this.financiacionAportada = financiacionAportada;
    }

    public ArrayList<Personal> getPersonalAsociado() {
        return personalAsociado;
    }

    public void setPersonalAsociado(ArrayList<Personal> personalAsociado) {
        this.personalAsociado = personalAsociado;
    }

    public Delegacion getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(Delegacion delegacion) {
        this.delegacion = delegacion;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", localizacion='" + localizacion + '\'' +
                ", lineAccion='" + lineAccion + '\'' +
                ", subLineaAccion='" + subLineaAccion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", socioLocal='" + socioLocal + '\'' +
                ", financiador='" + financiador + '\'' +
                ", financiacionAportada='" + financiacionAportada + '\'' +
                ", personalAsociado=" + personalAsociado +
                ", delegacion=" + delegacion +
                '}';
    }
}
