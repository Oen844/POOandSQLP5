package com.P5.DAO.interfaces;

import com.P5.entities.Delegacion;

import java.util.List;

public interface IDelegacion {
    public List<Delegacion> createDelegacion();

    public Delegacion readDelegacion(String ciudad);

    public void updateDelegacion(Delegacion delegacion);

    public void deleteDelegacion(Delegacion delegacion);
}
