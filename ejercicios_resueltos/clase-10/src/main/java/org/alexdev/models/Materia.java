package org.alexdev.models;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> materiasCorrelativas;

    public Materia() {
        this.materiasCorrelativas = new ArrayList<>();
    }

    public Materia(String nombre, List<Materia> materiasCorrelativas) {
        this.nombre = nombre;
        this.materiasCorrelativas = materiasCorrelativas;
    }

    public Materia(String nombre) {
        this.nombre = nombre;
        this.materiasCorrelativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMateriasCorrelativas() {
        return materiasCorrelativas;
    }

    public void setMateriasCorrelativas(List<Materia> materiasCorrelativas) {
        this.materiasCorrelativas = materiasCorrelativas;
    }
    public void addMateriaCorrelativa(Materia materia){
        this.materiasCorrelativas.add(materia);
    }
    public boolean esCorrelativa(Materia materia){
        return this.materiasCorrelativas.stream().anyMatch(ma -> ma.equals(materia));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Materia m){
            return this.nombre.equals(m.getNombre());
        }else{
            return false;
        }
    }
}
