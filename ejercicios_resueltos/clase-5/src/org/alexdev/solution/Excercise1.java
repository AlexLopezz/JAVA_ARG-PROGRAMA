package org.alexdev.solution;

import org.alexdev.classSolution.CarritoCompra;
import org.alexdev.classSolution.ItemCarrito;
import org.alexdev.classSolution.Persona;
import org.alexdev.classSolution.Producto;

public class Excercise1 {
    public static void main(String[] args) {
        Persona cliente1 = new Persona("Juan", "Perez", "32123123");
        Persona cliente2 = new Persona("Jorge", "Sanchez", "32123123");

        ItemCarrito[] itemsJuan = {
                new ItemCarrito(new Producto("Colgate", 250), 2),
                new ItemCarrito(new Producto("IPhone 11", 550),1),
                new ItemCarrito(new Producto("Lenovo TAB A7", 450),1)
        };
        ItemCarrito[] itemsAlex = {
                new ItemCarrito(new Producto("Monitor ASUS B231", 300), 1),
                new ItemCarrito(new Producto("Samsung s20 FE", 650),1),
                new ItemCarrito(new Producto("Mouse Logitech g203", 80),2)
        };

        CarritoCompra carritoJuan = new CarritoCompra(cliente1, itemsJuan);
        CarritoCompra carritoAlex = new CarritoCompra(cliente2, itemsAlex);

        System.out.println("Total de la compra del carrito de "+cliente1.getNombre()+": $"+ carritoJuan.getPrecioFinal());
        System.out.println("Total de la compra del carrito de "+cliente2.getNombre()+" $"+carritoAlex.getPrecioFinal());
    }
}
