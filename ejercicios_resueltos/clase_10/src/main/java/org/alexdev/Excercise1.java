package org.alexdev;

import org.alexdev.models.Alumno;
import org.alexdev.models.Inscripcion;
import org.alexdev.models.Materia;
import org.alexdev.models.ReadFilesItems;

import java.io.IOException;
import java.util.*;

public class Excercise1 {
    public static void main(String[] args) throws IOException {
        ReadFilesItems rf = new ReadFilesItems();
        String rutaCSV = System.getProperty("user.dir")+"\\clase_10\\src\\main\\resources\\inscripciones.csv";
        rf.setRuta(rutaCSV);
        String[] dataCSV = rf.getItemsFile();


        List<Materia> materiasActuales = creacionMateriasEjemplo();
        List<Alumno> alumnosActuales = creacionAlumnosEjemplo();

        imprimirResultadoInscripcion(dataCSV, materiasActuales, alumnosActuales);
    }
    static List<Materia> creacionMateriasEjemplo(){
        //Con esta lista retornaremos las materias.
        List<Materia> materias = new ArrayList<>();

        //Creacion de materias
        Materia progI = new Materia("Programacion I");
        Materia progII = new Materia("Programacion II");

        Materia baseDeDatosI = new Materia("Bases de datos I");
        Materia baseDeDatosII = new Materia("Bases de datos II");

        //Agregamos materias correlativas:
        baseDeDatosII.agregarMateriaCorrelativa(baseDeDatosI);
        progII.agregarMateriaCorrelativa(progI);

        //Agregamos a la lista, las materias creadas.
        materias.add(progI);
        materias.add(progII);
        materias.add(baseDeDatosI);
        materias.add(baseDeDatosII);

        return materias;
    }
    static List<Alumno> creacionAlumnosEjemplo(){
        List<Alumno>alumnos = new ArrayList<>();

        alumnos.add(
                new Alumno("Jose")
        );
        alumnos.add(
                new Alumno("Vanesa")
        );
        return alumnos;
    }
    static  void imprimirResultadoInscripcion(String[] itemsCSV, List<Materia> materiasActuales, List<Alumno> alumnosActuales) {
        for (int i = 0; i < itemsCSV.length;) {
            if (i != 0) {
                Inscripcion inscripcion = new Inscripcion();

                inscripcion.setAlumno(findAlumno(new Alumno(itemsCSV[i]), alumnosActuales));
                inscripcion.setMateria(findMateria(new Materia(itemsCSV[i+1]), materiasActuales));

                if(inscripcion.getAlumno() == null){
                    System.out.println(itemsCSV[i]+"\t"+itemsCSV[i+1]+"\t"+"No existe el alumno/a");
                }else if(inscripcion.getMateria() == null){
                    System.out.println(itemsCSV[i]+"\t"+itemsCSV[i+1]+"\t"+"No existe la materia que quiere cursar.");
                }else{
                    String resultadoAprobado = inscripcion.estaAprobada()? "Aprobado" : "Rechazado";
                    System.out.println(itemsCSV[i]+"\t"+itemsCSV[i+1]+"\t"+resultadoAprobado);
                }
            }
            i += 2;
        }
    }
    static Alumno findAlumno(Alumno alumno, List<Alumno> alumnosActuales) {
        return alumnosActuales.stream().filter(aa -> aa.getNombre().equals(alumno.getNombre())).findAny().orElse(null);
    }

    static Materia findMateria(Materia m, List<Materia> materias){
        return materias.stream().filter(materia -> materia.getNombre().equals(m.getNombre())).findAny().orElse(null);
    }
}

