package org.alexdev.models;

import lombok.Data;

import java.time.LocalDate;

@Data public class Persona {
    private String name, lastname;
    private LocalDate dateBirth;
}
