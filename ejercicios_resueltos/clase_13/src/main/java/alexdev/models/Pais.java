package alexdev.models;

import lombok.Getter;
import lombok.Setter;

public class Pais {
    @Getter @Setter
    private String nombre;

    public Pais() {
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
