package org.alexdev.models;

import java.time.LocalDate;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private LocalDate fecha;

    public Inscripcion(Alumno alumno, Materia materia, LocalDate fecha) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public boolean aprobada(){
        /*
        *¿Como sabemos si la inscripcion esta aceptada?
        * La inscripcion esta aceptada si la materia no tiene correlativas.
        * La inscripcion esta aceptada si la materia tiene correlativas y el alumno cumple con todas ellas.
         */
        return !this.materia.tieneCorrelativas() || this.materia.puedeCursar(this.alumno);
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "alumno=" + alumno +
                ", materia=" + materia +
                ", fecha=" + fecha +
                '}';
    }
}
