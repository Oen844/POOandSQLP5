package com.P5.DAO.interfaces;

import com.P5.entities.Proyecto;

import java.util.List;

public interface IProyecto {
    public List<Proyecto> findProyectosDelegacion(String delgacionId);

    public Proyecto readProyecto(String id);

    public void createProyecto(Proyecto proyecto);

    public Proyecto updateProyecto(Proyecto proyecto);

    public void deleteProyecto(String id);
}
