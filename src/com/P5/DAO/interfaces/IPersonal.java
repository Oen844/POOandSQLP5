package com.P5.DAO.interfaces;


import com.P5.entities.Personal;

import java.util.List;

public interface IPersonal {
    public List<Personal> createPersonal();

    public Personal readPersonal(int idPersona);

    public void updatePersonal(Personal persona);

    public void deletePersonal(Personal persona);
}
