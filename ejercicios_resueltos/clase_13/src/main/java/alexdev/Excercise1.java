package alexdev;

import alexdev.repositories.PaisRepositorio;
import alexdev.models.Departamento;
import alexdev.models.Empleado;
import alexdev.models.Pais;
import alexdev.repositories.DepartamentoRepositorio;
import alexdev.repositories.EmpleadoRepositorio;


import java.util.ArrayList;
import java.util.List;


public class Excercise1 {
    public static void main(String[] args) {

        //Variables de entrada
        PaisRepositorio pr = new PaisRepositorio();
        EmpleadoRepositorio er = new EmpleadoRepositorio();
        DepartamentoRepositorio dp = new DepartamentoRepositorio();
        List<Pais> paisesDB = paisesACrearDB();
        List<Empleado> empleadosDB = empleadosACrearDB();
        List<Departamento> departamentosDB = departamentosACrearDB();


        //Insertamos paises y departamentos de ejemplo en DB con datos ficticios:
        paisesDB.forEach(pr::insertPaisDB);
        departamentosDB.forEach(dp::insertDepartamentoDB);

        //1. Insertamos nuevos empleados en DB:
        for(Empleado emp : empleadosDB){
            er.insertEmpleadoDB(emp);
        }


        //2. Modificar la nacionalidad de algun empleado:
        //Obtenemos un empleado cualquiera que fue almacenado en DB:
        Empleado empleado = er.findEmpleadoDB(empleadosDB.get(2).getDNI());
        System.out.println("Datos del empleado a modificar: "+ empleado);
        //Seteamos la nacionalidad, a otro de la lista de paises recientmente agregado a DB:
        empleado.setNacionalidad(paisesDB.get(2));
        //Actualizamos con los datos:
        er.updateEmpleadoDB(empleado);

        //Buscamos en DB el empleado modificado:
        empleado = er.findEmpleadoDB(empleado.getDNI());
        //Verificamos que efectivamente si cambio su nacionalidad:
        System.out.println("Datos del empleado a modificado: "+ empleado);

        //3. Eliminamos un departamento cualquiera:
        dp.deleteDepartmentDB(departamentosDB.get(2).getNombre());


        //4. Conocer los empleados que trabajan en el departamento de “logística”.
        Departamento comunicacionesDepa = departamentosDB.stream()
                .filter(d -> d.getNombre().equals("Logistica"))
                .findAny().orElseThrow();

        List<Empleado> empleadosComunicaciones = er.findToDepartament(comunicacionesDepa.getNombre());
        System.out.println("-> Empleados del area de comunicaciones ordenados alfabeticamente: ");
        empleadosComunicaciones.forEach(System.out::println);


        //5. Mostrar todos los departamentos ordenados alfabéticamente.
        System.out.println("-> Listado de todos los departamentos ordenados alfabeticamente: ");
        dp.allDepartamentDB().forEach(System.out::println);

        //Limpiamos la info creada en la DB:
        er.clearEmpleadosDB();
        dp.clearDepartamentosDB();
        pr.clearPaisesDB();

    }

    static List<Pais> paisesACrearDB(){
        List<Pais> paises = new ArrayList<>();
        paises.add(
                new Pais("Argentina")
        );
        paises.add(
                new Pais("Ecuador")
        );
        paises.add(
                new Pais("Uruguay")
        );
        return paises;
    }
    static List<Departamento> departamentosACrearDB(){
        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(
                new Departamento("Logistica",
                        54321.23)
        );
        departamentos.add(
                new Departamento(
                        "Marketing",
                        12345.23)
        );
        departamentos.add(
                new Departamento(
                        "Sistemas",
                        25314.12
                )
        );
        return departamentos;
    }
    static List<Empleado> empleadosACrearDB(){
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(
                new Empleado(
                        "213131",
                        "Alex",
                        "Lopez",
                        new Pais("Argentina"),
                        new Departamento(
                                "Logistica",
                                54321.23
                        )
                ));
        empleados.add(
                new Empleado(
                        "213231",
                        "Armando",
                        "Paredes",
                        new Pais("Argentina"),
                        new Departamento(
                                "Logistica",
                                54321.23
                        )
                )
        );
        empleados.add(
                new Empleado(
                        "1231111",
                        "Beatriz",
                        "Salomon",
                        new Pais("Ecuador"),
                        new Departamento(
                                "Logistica",
                                54321.23
                        )
                )
        );
        empleados.add(
                new Empleado(
                        "21213131",
                        "Joaquino",
                        "Lopez",
                        new Pais("Uruguay"),
                        new Departamento(
                                "Marketing",
                                12345.23
                        )
                )
        );
        empleados.add(new Empleado(
                "212113131",
                "Gervasio",
                "Nuñez",
                new Pais("Uruguay"),
                new Departamento(
                        "Marketing",
                        12345.23
                )
        ));
        return empleados;
    }

}
