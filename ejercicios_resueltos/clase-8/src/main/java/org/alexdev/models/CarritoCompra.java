package org.alexdev.models;


import org.alexdev.exceptions.DescuentoCero;
import org.alexdev.exceptions.SinPrecioDescuento;
import org.alexdev.models.abstractClass.Descuento;
import org.alexdev.models.descuento.DescuentoFijo;
import org.alexdev.models.descuento.DescuentoPorcentaje;
import org.alexdev.models.persona.Cliente;

import java.util.ArrayList;
import java.util.List;


public class CarritoCompra {
    private Cliente cliente;
    private List<ItemCarrito> items;


    public CarritoCompra() {
        this.items = new ArrayList<>();
    }

    public CarritoCompra(Cliente cliente, List<ItemCarrito> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }

    public void addItems(ItemCarrito item) {
        this.items.add(item);
    }

    public void addItems(List<ItemCarrito> itemsAdd) {
        items.addAll(itemsAdd);
    }

    public double getPrecioFinal() {
        return montoItems();
    }

    public double getPrecioFinal(Descuento desc) throws SinPrecioDescuento, DescuentoCero {
        if (this.getPrecioFinal() > 0) {
            if( (this.getPrecioFinal() - montoDesc(desc, (int)this.getPrecioFinal())) > 0) {
                return this.getPrecioFinal() - montoDesc(desc, (int)this.getPrecioFinal());
            }else{
                throw new DescuentoCero("El resultado del descuento no debe ser un monto negativo.");
            }
        } else {
            throw new SinPrecioDescuento("No se puede obtener un descuento debido a que el precio final es 0.");
        }
    }

    private double montoItems() {
        double monto = 0;
        for (ItemCarrito c : this.getItems()) {
            monto += c.getPrecioTotal();
        }
        return monto;
    }

    public double montoDesc(Descuento desc, int precio) {
        if (desc instanceof DescuentoFijo descFijo) {
            return descFijo.descuento(precio);
        } else if (desc instanceof DescuentoPorcentaje descuentoPorcentaje) {
            return descuentoPorcentaje.descuento(precio);
        }
        return 0;
    }

}
