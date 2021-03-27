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
    private String financiacionAportada;

    ArrayList<Personal>personalProyecto = new ArrayList<>();    //lista de personal que va trabajar en el proyecto

    public Proyecto(String nombre, String pais, String localizacion, String lineAccion, String subLineaAccion, Date fechaInicio, Date fechaFin, String financiacionAportada, ArrayList<Personal> personalProyecto) {
        this.nombre = nombre;
        this.pais = pais;
        this.localizacion = localizacion;
        this.lineAccion = lineAccion;
        this.subLineaAccion = subLineaAccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.financiacionAportada = financiacionAportada;
        this.personalProyecto = personalProyecto;
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

    public String getFinanciacionAportada() {
        return financiacionAportada;
    }

    public void setFinanciacionAportada(String financiacionAportada) {
        this.financiacionAportada = financiacionAportada;
    }


}
