package org.alexdev.models;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String legajo;
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String legajo, String nombre, List<Materia> materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasAprobadas = materiasAprobadas;
    }

    public Alumno(String legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }
    public void addMateriasAprobadas(Materia materia){
        this.materiasAprobadas.add(materia);
    }

    public boolean tenesCorrelativa(Materia m){
        return this.materiasAprobadas.contains(m);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Alumno a){
            return this.nombre.equals(a.getNombre());
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
