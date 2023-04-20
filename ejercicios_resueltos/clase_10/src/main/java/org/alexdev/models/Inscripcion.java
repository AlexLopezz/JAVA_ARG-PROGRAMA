package org.alexdev.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Inscripcion {
    @Getter @Setter
    private Alumno alumno;
    @Getter @Setter
    private Materia materia;
    @Getter @Setter
    private LocalDate date;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia, LocalDate date) {
        this.alumno = alumno;
        this.materia = materia;
        this.date = date;
    }

    public boolean estaAprobada(){
        /*
         * ¿Cómo sabemos si la inscripción está aceptada?
         *  - La inscripción está aceptada (true) si la materia No tiene correlativas
         *  - La inscripción está aceptada (true) si la materia tiene correlativas y el alumno cumple
         *  con todas ellas
         */
        return !materia.tieneCorrelativas() || (materia.tieneCorrelativas() && materia.puedeCursar(alumno));
    }

    @Override
    public String toString() {
        return alumno.getNombre()+"\t"+materia.getNombre()+"\t"+estaAprobada();
    }
}
