package org.alexdev.solution.models.descuento;


import org.alexdev.solution.models.abstractClass.Descuento;

public class DescuentoPorcentaje extends Descuento {
    private Double porcentaje;

    public DescuentoPorcentaje() {
    }

    public DescuentoPorcentaje(Double porcentaje) {

        if(porcentaje > 0 && porcentaje < 100) {
            this.porcentaje = porcentaje;
        }else{
            this.porcentaje = 0.0;
        }
    }

    @Override
    public int descuento(int base){
        return porcentaje > 0? (int) (base * (porcentaje / 100)) : base;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        if(porcentaje > 0 && porcentaje < 100) {
            this.porcentaje = porcentaje;
        }else{
            this.porcentaje = 0.0;
        }
    }
}
