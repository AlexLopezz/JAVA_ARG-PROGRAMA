package models.descuento;

import java.time.LocalDate;

public abstract class Descuento {
    protected double valorDesc;
    public abstract double descuento(double valorInicial);

    public double getValorDesc() {
        return valorDesc;
    }
    public void setValorDesc(double valorDesc) throws Exception {
        this.valorDesc = valorDesc;
    }
}
