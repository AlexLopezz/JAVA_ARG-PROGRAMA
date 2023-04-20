package org.alexdev.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    @Getter @Setter
    String legajo, nombre;
    @Getter @Setter
    private List<Materia> materiasAprobadas = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public Alumno(String legajo, String nombre, List<Materia> materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean contieneMateriaCorrelativa(Materia materia){
        return this.materiasAprobadas.contains(materia);
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
