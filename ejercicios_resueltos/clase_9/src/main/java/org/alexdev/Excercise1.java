package org.alexdev;

import org.alexdev.models.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();
        boolean follow = true;


        while(follow) {
            System.out.print("> Ingrese por pantalla el nombre de la persona: ");
            String nombre = read.nextLine();
            System.out.print("> Ingrese por pantalla el apellido de la persona: ");
            String apellido = read.nextLine();
            System.out.print("> Ingrese por pantalla la fecha de nacimiento de la persona (YYYY/MM/DD): ");
            String fechaNacimiento = read.nextLine();

            String[] aux = formatFechaNacimiento(fechaNacimiento);

            Persona persona = new Persona();
            persona.setName(nombre);
            persona.setLastname(apellido);
            persona.setDateBirth(LocalDate.of(
                    Integer.parseInt(aux[0]),
                    Integer.parseInt(aux[1]),
                    Integer.parseInt(aux[2])));

            personas.add(persona);

            System.out.println("¿Desea seguir ingresando personas? Escriba 'SI' si es que lo desea, caulquier letra para NO.");
            String decision = read.nextLine();
            decision = decision.replace(" ", "");

            follow = decision.equalsIgnoreCase("si");
        }
        System.out.println("Cantidad de personas ingresadas: "+ personas.size());
        System.out.println("Listado de personas ingresadas: ");
        printPersonas(personas);

    }

    private static void printPersonas(List<Persona> personas) {
        personas.forEach(
                pe -> {
                    System.out.println("Nombre: "+pe.getName()+" | Apellido: "+pe.getLastname()+" | Fecha nacimiento: "+pe.getDateBirth());
                }
        );
    }

    public static String[] formatFechaNacimiento(String fecha){
        return fecha.replace(" ","").split("/");
    }
}


