package org.alexdev.solution;


import models.*;
import models.descuento.DescuentoFijo;
import models.descuento.DescuentoPorcentaje;
import models.persona.Cliente;

public class Excercise1 {
    public static void main(String[] args) {
        //Creamos un cliente para vincularlo con un carrito
        Cliente cliente = new Cliente(
                "45687942",
                "Alex",
                "Lopez");

        //Creamos una lista de items para vincularlo al carrito
        ItemCarrito[] items = {
                new ItemCarrito(new Producto(
                        "Yogurt La Serenisima",
                        200
                ), 2),
                new ItemCarrito(new Producto(
                        "Leche La lechera",
                        300
                ), 1),
                new ItemCarrito(new Producto(
                        "Queso Cremoso Cremolatti",
                        500
                ), 2),
                new ItemCarrito(new Producto(
                        "Pan Frances",
                        350
                ), 2)
        };
        // Creamos el carrito y lo vinculamos con el cliente y los items creados.
        CarritoCompra carrito = new CarritoCompra(cliente, items);

        //Demostracion del funcionamiento:
        System.out.println("Precio final (Sin descuento): $"+carrito.getPrecioFinal());


        double valorDescPorcentaje = 20,
        valorDescFijo = 200; //Creamos un porcentaje ficticio para el ejemplo del descuento con procentaje.

        DescuentoFijo descFijo = new DescuentoFijo(valorDescFijo); //Instanciamos un nuevo objeto para la demostracion del descuento fijo.
        DescuentoPorcentaje descPorcentaje = new DescuentoPorcentaje(valorDescPorcentaje);  //Instanciamos un nuevo objeto para la demostracion del descuento con porcentaje.

        System.out.println("Precio final (Con descuento de monto fijo): $"+carrito.getPrecioFinal(descFijo));
        System.out.println("Precio final (Con descuento % porcentaje): $"+carrito.getPrecioFinal(descPorcentaje));

    }
}
