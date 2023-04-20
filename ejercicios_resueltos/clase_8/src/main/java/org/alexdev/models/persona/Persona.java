package org.alexdev.models.persona;

public abstract class Persona {
    String nombre;
    String apellido;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
