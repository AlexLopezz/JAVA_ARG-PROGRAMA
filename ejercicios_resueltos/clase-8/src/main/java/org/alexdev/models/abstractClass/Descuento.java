package org.alexdev.models.abstractClass;

import java.time.LocalDate;

public abstract class Descuento {
    protected LocalDate comienzoDesc;
    protected LocalDate finDesc;

    protected abstract int descuento(int base);
}
