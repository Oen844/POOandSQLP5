package com.P5.entities;

public class Empleado extends Personal {

    private float salario;

    public Empleado(int idPersona, String nombre, String dni, String direccion, float salario) {
        super(idPersona, nombre, dni, direccion);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
