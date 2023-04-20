package org.alexdev.models;


import org.alexdev.exceptions.DescuentoCero;
import org.alexdev.exceptions.SinPrecioDescuento;
import org.alexdev.models.descuento.Descuento;
import org.alexdev.models.descuento.DescuentoFijo;
import org.alexdev.models.descuento.DescuentoPorcentaje;
import org.alexdev.models.descuento.DescuentoPorcentajeConTope;
import org.alexdev.models.persona.Cliente;

import java.util.ArrayList;
import java.util.List;


public class CarritoCompra {
    private Cliente cliente;
    private List<ItemCarrito> itemsCarrito;


    public CarritoCompra() {
        this.itemsCarrito = new ArrayList<>();
    }

    public CarritoCompra(Cliente cliente, List<ItemCarrito> items) {
        this.cliente = cliente;
        this.itemsCarrito = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCarrito> getItemsCarrito() {
        return itemsCarrito;
    }

    public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
        this.itemsCarrito = itemsCarrito;
    }

    public void addItems(ItemCarrito item) {
        this.itemsCarrito.add(item);
    }

    public void addItems(List<ItemCarrito> itemsAdd) {
        itemsCarrito.addAll(itemsAdd);
    }

    public double getPrecioFinal() {
        double precioFinal=0;
        for(ItemCarrito i : itemsCarrito){
            precioFinal += i.getPrecioFinalItem();
        }
        return precioFinal;
    }

    public double getPrecioFinal(Descuento desc) throws SinPrecioDescuento, DescuentoCero {
        double precioFinal = 0d;
        if(getPrecioFinal() > 0) {
            if (desc instanceof DescuentoPorcentaje dp) {
                if (dp instanceof DescuentoPorcentajeConTope dt) {
                    precioFinal = dt.descuento(getPrecioFinal());
                } else {
                    precioFinal = dp.descuento(getPrecioFinal());
                }
            } else if (desc instanceof DescuentoFijo df) {
                precioFinal = df.descuento(getPrecioFinal());
            } else {
                precioFinal = getPrecioFinal();
            }
        }else{
            throw new SinPrecioDescuento("No se puede aplicar descuento, debido a que el monto del carrito es $0.");
        }

        if(precioFinal > 0){
            return precioFinal;
        }else{
            throw new DescuentoCero("No se puede aplicar descuento, debido a que el monto final con descuento es negativo.");
        }
    }
}
