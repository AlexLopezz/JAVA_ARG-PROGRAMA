package org.alexdev;

import org.alexdev.models.Alumno;
import org.alexdev.models.Inscripcion;
import org.alexdev.models.Materia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Materia> materias = new ArrayList<>();
        Materia prog = new Materia("Programacion I");
        Materia progII = new Materia("Programacion II");
        Materia dba = new Materia("Base de datos I");
        Materia dbaII = new Materia("Base de datos II");

        progII.addMateriaCorrelativa(prog);
        dba.addMateriaCorrelativa(dbaII);

        materias.add(prog);
        materias.add(progII);
        materias.add(dba);
        materias.add(dbaII);


        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("4321", "Jose Rodriguez"));
        alumnos.add(new Alumno("4321", "Vanesa Sosa"));



        String[] auxString = leerArchivo("C:\\Users\\alexdev\\Documents\\GitHub\\JAVA_ARG-PROGRAMA\\ejercicios_resueltos\\clase-10\\src\\main\\resources\\inscripciones.csv"); //Le pasamos por argumento la ruta donde se encuentra el archivo csv.
        List<Inscripcion> inscripciones = new ArrayList<>();
        int auxInt = 0;

        for(int i = 0; i < auxString.length / 2; i++){
            inscripciones.add(
                    new Inscripcion(
                            getAlumno(alumnos, new Alumno(auxString[auxInt+0])).get()
                            ,
                            getMateria(materias, new Materia(auxString[auxInt+1])).get(),
                            LocalDate.now()
                    )
            );

            auxInt+=2;
        }

        System.out.println(inscripciones);

    }
    static String[] leerArchivo(String path) throws IOException {
        return String.valueOf(Files.readAllLines(Path.of(path)))
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n")
                .replace(";", "\n")
                .split("\n");
    }
    public static Optional<Alumno> getAlumno(List<Alumno>alumnos, Alumno alumno){
        return alumnos
                .stream()
                .filter(a -> a.equals(alumno))
                .findAny();
    }
    public static Optional<Materia> getMateria(List<Materia>materias, Materia materia){
        return materias
                .stream()
                .filter(m -> m.equals(materia))
                .findAny();
    }



}
