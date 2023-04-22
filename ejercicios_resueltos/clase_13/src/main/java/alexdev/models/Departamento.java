package alexdev.models;

import lombok.Getter;
import lombok.Setter;

public class Departamento {
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private double presupuesto;

    public Departamento() {
    }

    public Departamento(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
