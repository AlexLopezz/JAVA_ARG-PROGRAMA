package org.alexdev.models;

import lombok.Data;

import java.time.LocalDate;


@Data public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
}
