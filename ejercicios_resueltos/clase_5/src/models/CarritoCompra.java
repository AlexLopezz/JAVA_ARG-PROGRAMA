package models;

import models.descuento.Descuento;
import models.descuento.DescuentoFijo;
import models.descuento.DescuentoPorcentaje;
import models.descuento.DescuentoPorcentajeConTope;
import models.persona.Cliente;

import java.util.List;


public class CarritoCompra {
    private Cliente cliente;
    ItemCarrito[] itemsCarrito;

    public CarritoCompra(Cliente cliente, ItemCarrito[] items) {
        this.cliente = cliente;
        this.itemsCarrito = items;
    }

    public CarritoCompra() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItems(ItemCarrito[] items) {
        this.itemsCarrito = items;
    }

    public ItemCarrito[] getItems() {
        return itemsCarrito;
    }
    public double getPrecioFinal(){
        double precioFinal=0;
        for(ItemCarrito i : itemsCarrito){
            precioFinal += i.getPrecioFinalItem();
        }
        return precioFinal;
    }
    public double getPrecioFinal(Descuento desc){
        double precioFinal = 0d;
        if(desc instanceof DescuentoPorcentaje dp){
            if(dp instanceof DescuentoPorcentajeConTope dt){
                precioFinal = dt.descuento(getPrecioFinal());
            }else{
                precioFinal = dp.descuento(getPrecioFinal());
            }
        }else if (desc instanceof DescuentoFijo df){
            precioFinal = df.descuento(getPrecioFinal());
        }else {
            precioFinal = getPrecioFinal();
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("can. precio unitario producto\n");
        for(ItemCarrito i : this.getItems()){
            sb.append(i.getCantidad()).append("\t").
                    append(i.getItem().getPrecio()).append("\t").
                    append(i.getItem().getNombre()).append("\n");
        }
        return sb.toString();
    }
}
