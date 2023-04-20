package org.alexdev.models.descuento;


public class DescuentoPorcentaje extends Descuento {

    public DescuentoPorcentaje() {
    }

    public DescuentoPorcentaje(double valorDesc){
        this.valorDesc = valorDesc;
    }
    public void setValorDesc(double valorDesc) throws Exception {
        if(valorDesc > 0 && valorDesc < 100) {
            this.valorDesc = valorDesc;
        }else{
            throw new Exception("El valor del descuento no debe ser mayor al valor final o al 100% del descuento.");
        }
    }
    @Override
    public double descuento(double valorInicial) {
        double desc = valorInicial * (this.valorDesc / 100);
        return valorInicial - desc;
    }
}
