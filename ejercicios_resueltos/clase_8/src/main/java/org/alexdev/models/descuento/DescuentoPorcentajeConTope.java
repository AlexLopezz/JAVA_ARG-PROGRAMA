package org.alexdev.models.descuento;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje {
    private double tope;

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
    public double getTope() {
        return tope;
    }

    public void setTope(double tope) {
        this.tope = tope;
    }
}
