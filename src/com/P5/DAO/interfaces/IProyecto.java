package com.P5.DAO.interfaces;

import com.P5.entities.Proyecto;

import java.util.List;

public interface IProyecto {
    public List<Proyecto> createProyecto();
    public Proyecto readProyecto (String nombre);
    public void updateProyecto (Proyecto proyecto);
    public void deleteProyecto (Proyecto proyecto);
}
