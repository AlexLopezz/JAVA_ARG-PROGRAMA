package models.descuento;

import lombok.Getter;
import lombok.Setter;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje {
    @Getter @Setter
    private double tope = 100;

    public DescuentoPorcentajeConTope() {
    }

    public DescuentoPorcentajeConTope(double valorDesc, double tope) {
        super(valorDesc);
        this.tope = tope;
    }

    public DescuentoPorcentajeConTope(double tope) throws Exception {
        if(tope > 0 && tope <= 100){
            this.tope = tope;
            super.setValorDesc(tope);
        }else {
            throw new Exception("El tope debe estar entre el rango 1% - 100%.");
        }
    }

    @Override
    public void setValorDesc(double nuevoValorDesc) throws Exception {
        //Mientras que el valor sea menor/igual al tope, entonces modificaremos el valor de descuento.
        if(nuevoValorDesc <= tope){
            super.setValorDesc(nuevoValorDesc);
        }
    }

    @Override
    public String toString() {
        return "DescuentoPorcentajeConTope: " +
                "Valor descuento: %" + valorDesc +
                " | Tope descuento: %" + tope;
    }
}
