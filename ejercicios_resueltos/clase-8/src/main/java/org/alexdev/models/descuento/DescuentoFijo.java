package org.alexdev.models.descuento;


import org.alexdev.models.abstractClass.Descuento;

public class DescuentoFijo extends Descuento {
    private int monto;

    public DescuentoFijo(int monto) {
        this.monto = Math.max(monto, 0);
    }

    @Override
    public int descuento(int base) {
        if (monto < base && monto > 0) {
            return monto;
        }
        return 0;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}

