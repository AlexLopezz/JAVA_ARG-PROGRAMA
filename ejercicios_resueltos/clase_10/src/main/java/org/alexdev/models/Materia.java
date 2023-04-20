package org.alexdev.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private List<Materia> materiasCorrelativas = new ArrayList<>();

    public Materia() {
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Materia(String nombre, List<Materia> materiasCorrelativas) {
        this.nombre = nombre;
        this.materiasCorrelativas = materiasCorrelativas;
    }

    public void agregarMateriaCorrelativa(Materia materia){
        this.materiasCorrelativas.add(materia);
    }

    /**
     *  Este metodo indica si la materia actual la puede cursar un alumno
     * en particular.
     * @param alumno Un alumno en particular.
     * @return true si puede cursar, false de lo contrario.
     */
    public boolean puedeCursar(Alumno alumno){
        return this.materiasCorrelativas
                .stream()
                .allMatch(alumno::contieneMateriaCorrelativa);
    }

    /**
     *  Este metodo me indica si la materia tiene correlativas o no.
     * @return true si las tiene, false de lo contrario.
     */
    public boolean tieneCorrelativas(){
        return !this.materiasCorrelativas.isEmpty();
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
