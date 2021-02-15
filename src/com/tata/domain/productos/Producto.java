package com.tata.domain.productos;

public class Producto {
    public static Integer id = 0;
    private String nombre;
    private float precio;

    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
        id++;
    }

    public void imprimirDatos(int id) {
        System.out.println( id + "\t" +
                            this.nombre + "\t" +
                            this.precio );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
