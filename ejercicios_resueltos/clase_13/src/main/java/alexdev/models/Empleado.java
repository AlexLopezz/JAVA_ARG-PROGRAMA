package alexdev.models;

import lombok.Getter;
import lombok.Setter;

public class Empleado {
    @Getter @Setter
    private String DNI,
    nombre, apellido;
    @Getter @Setter
    private Pais nacionalidad;
    @Getter @Setter
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(String DNI, String nombre, String apellido, Pais nacionalidad, Departamento departamento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return this.DNI+"\t"+
                this.nombre+"\t"+
                this.apellido+"\t"+
                this.nacionalidad+"\t"+
                this.departamento;
    }
}
