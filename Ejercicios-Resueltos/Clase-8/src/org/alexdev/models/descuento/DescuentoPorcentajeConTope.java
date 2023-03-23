package org.alexdev.models.descuento;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje {
    private double tope;

    public DescuentoPorcentajeConTope(double tope) {
        this.tope = tope > 0 && tope < 100 ? tope : 0;
        super.setPorcentaje(tope);
    }

    @Override
    public void setPorcentaje(Double porcentaje) {
        if (porcentaje >= tope && porcentaje > 0) {
            super.setPorcentaje(tope); //No podremos cambiar el porcentaje, debido a que sobrepasa el tope, por lo cual, el porcentaje quedara en el tope.
        } else if (porcentaje > 0) {
            super.setPorcentaje(porcentaje); //Seteamos sin problema, si el porcentaje es menor al tope.
        } else {
            super.setPorcentaje(tope);
        }
    }

    public double getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    @Override
    public int descuento(int base) {
        return super.descuento(base);
    }
}
