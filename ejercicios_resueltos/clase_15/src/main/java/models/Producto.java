package models;

import lombok.Getter;
import lombok.Setter;


public class Producto {
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
