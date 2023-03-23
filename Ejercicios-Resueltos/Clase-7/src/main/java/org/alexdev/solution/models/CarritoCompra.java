package org.alexdev.solution.models;


import org.alexdev.solution.models.abstractClass.Descuento;
import org.alexdev.solution.models.descuento.DescuentoFijo;
import org.alexdev.solution.models.descuento.DescuentoPorcentaje;
import org.alexdev.solution.models.persona.Cliente;

public class CarritoCompra {
    private Cliente cliente;
    private ItemCarrito[] items;


    public CarritoCompra() {
    }

    public CarritoCompra(Cliente cliente, ItemCarrito[] items) {
        this.cliente = cliente;
        this.items = items;
    }

    public void setItems(ItemCarrito[] items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemCarrito[] getItems() {
        return items;
    }
    public double getPrecioFinal() {
        return montoItems();
    }
    public double getPrecioFinal(Descuento desc) {
        return this.getPrecioFinal() - montoDesc(desc);
    }
    private double montoItems(){
        double monto= 0;
        for(ItemCarrito c : this.getItems()){
            monto+= c.getPrecioTotal();
        }
        return monto;
    }
    public double montoDesc(Descuento desc){
        if( desc instanceof DescuentoFijo descFijo ){
            return descFijo.descuento((int)this.getPrecioFinal());
        }else if(desc instanceof DescuentoPorcentaje descuentoPorcentaje){
            return descuentoPorcentaje.descuento((int)this.getPrecioFinal());
        }
        return 0;
    }

}
