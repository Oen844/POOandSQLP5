package com.P5.DAO.interfaces;


import com.P5.entities.Personal;
import com.P5.entities.Proyecto;

import java.util.List;

public interface IPersonal {
    public List<Personal> findPersona(Integer idPersona);

    public Personal readPersonal(Integer idPersona);

    public void updatePersonal(Personal persona);

    public void deletePersonal(Personal persona);

    public void createPersonal(Personal persona);
}
