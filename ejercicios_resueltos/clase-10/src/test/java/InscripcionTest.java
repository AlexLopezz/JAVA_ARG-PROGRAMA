import org.alexdev.models.Alumno;
import org.alexdev.models.Inscripcion;
import org.alexdev.models.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class InscripcionTest {
    Alumno alumnoTest;
    Materia materiaTest;
    Inscripcion inscripcionTest;
    boolean resultadoActual;

    @BeforeEach
    void initTest(){
        alumnoTest = new Alumno("Alex");
        materiaTest = new Materia("Programacion I");
    }
    @Test
    @DisplayName("Validando si la materia tiene o no correlativas.")
    void MateriaSinCorrelativaTest(){
        //Almacenamos en un boolean, si la materia contiene o no correlativas.
        resultadoActual =  materiaTest.tieneCorrelativas();
        //Deberia dar false, ya que no las tiene.
        Assertions.assertFalse(resultadoActual);

        Materia materiaTest2 = new Materia("Programacion II");

        //Agregamos una nueva correlativa a la materia creada
        materiaTest2.addMateriaCorrelativa(materiaTest);
        resultadoActual = materiaTest2.tieneCorrelativas();
        //Ahora si deberia de ser true, ya que contiene almenos una materia correlativa.
        Assertions.assertTrue(resultadoActual);

    }
    @Test
    @DisplayName("Validando la inscripcion de una materia sin correlativas.")
    void SinCorrelativaTest(){
        //Generamos una nueva inscripcion con una materia sin correlativas:
        inscripcionTest = new Inscripcion(alumnoTest,materiaTest,LocalDate.now());
        //Capturamos el resultado de la inscripcion:
        resultadoActual = inscripcionTest.aprobada();
        //Deberia dar true, ya que la materia no tiene correlativas.
        Assertions.assertTrue(resultadoActual);
    }

    @Test
    @DisplayName("Validando inscripcion, si el alumno intenta inscribirse a una materia con correlativas de materias ya aprobadas.")
    void CorrelativaAlumnoTest(){
        Materia materiaTest2 = new Materia("Programacion II");

        //Agregamos una nueva correlativa a la materia creada en linea 33:
        materiaTest2.addMateriaCorrelativa(materiaTest);
        //Añadimos a las materias aprobadas del alumno, la materia correlativa:
        alumnoTest.addMateriasAprobadas(materiaTest);

        //Creamos una inscripcion de dicha materia creada.
        inscripcionTest = new Inscripcion(alumnoTest,materiaTest2,LocalDate.now());

        //Capturamos el resultado de la inscripcion:
        resultadoActual = inscripcionTest.aprobada();
        //Deberia dar true, debido a que la materia que se esta intentando inscribir es correlativa con una materia ya aprobada.
        Assertions.assertTrue(resultadoActual);
    }

}
