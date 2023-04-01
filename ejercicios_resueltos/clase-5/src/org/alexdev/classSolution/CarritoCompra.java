package org.alexdev.classSolution;

import java.util.Arrays;

public class CarritoCompra {
    private Persona cliente;
    ItemCarrito[] items = new ItemCarrito[3];

    public CarritoCompra(Persona cliente, ItemCarrito[] items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public ItemCarrito[] getItems() {
        return items;
    }
    public double getPrecioFinal(){
        double precioFinal=0;
        for(ItemCarrito i : items){
            precioFinal += i != null? i.getPrecioFinalItem() : 0;
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
