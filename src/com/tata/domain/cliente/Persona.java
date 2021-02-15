package com.tata.domain.cliente;

import com.tata.util.Mensaje;

public abstract class Persona {

    private String nombreCompleto;
    private int telefono;
    private int edad;
    private String ciudad;

    public Persona(String nombreCompleto, int telefono, int edad, String ciudad) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public abstract void imprimirDatos();

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
