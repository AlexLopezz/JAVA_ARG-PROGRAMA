package models;

import lombok.Getter;
import lombok.Setter;
import models.descuento.DescuentoPorcentajeConTope;



public class Oferta {
    @Getter @Setter
    private Producto producto;
    @Getter @Setter
    private DescuentoPorcentajeConTope descuento;
    @Getter @Setter
    private String fechaDesde;
    @Getter @Setter
    private String fechaHasta;

    public Oferta() {
    }

    public Oferta(Producto producto, DescuentoPorcentajeConTope descuento, String fechaDesde, String fechaHasta) {
        this.producto = producto;
        this.descuento = descuento;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "producto=" + producto +
                ", descuento=" + descuento +
                ", fechaDesde=" + fechaDesde +
                ", fechaHasta=" + fechaHasta +
                '}';
    }
}
