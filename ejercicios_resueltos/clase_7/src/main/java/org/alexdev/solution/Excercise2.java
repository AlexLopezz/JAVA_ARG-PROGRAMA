package org.alexdev.solution;

import models.*;
import models.descuento.*;
import models.persona.Cliente;

public class Excercise2 {
    public static void main(String[] args) throws Exception {
        //Creamos un cliente para vincularlo con un carrito
        Cliente cliente = new Cliente(
                "Alex",
                "Lopez",
                "45687942");

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

        double topePorcentaje = 50,
                valorDescPorcentaje = 40,
                valorDescFijo = 500;

        double precioFinal = carrito.getPrecioFinal();
        String nombreCliente = cliente.getNombre();

        //Salida:
        //Sin descuentos...
        System.out.println("Precio final del carrito de " + nombreCliente + ": $" + precioFinal);
        //Descuento fijo:
        precioFinal = carrito.getPrecioFinal(new DescuentoFijo(valorDescFijo));
        System.out.println("(Descuento fijo) - Precio final del carrito de " + nombreCliente + ": $" + precioFinal);
        //Descuento porcentaje:
        precioFinal = carrito.getPrecioFinal(new DescuentoPorcentaje(valorDescPorcentaje));
        System.out.println("(Descuento porcentaje) - Precio final del carrito de " + nombreCliente + ": $" + precioFinal);
        //Descuento con tope de porcentaje:
        DescuentoPorcentajeConTope dt = new DescuentoPorcentajeConTope(topePorcentaje);
        precioFinal = carrito.getPrecioFinal(dt);
        System.out.println("(Descuento porcentaje con tope de %"+dt.getValorDesc()+") - Precio final del carrito de " + nombreCliente + ": $" + precioFinal); //Funciona.
        //Intentamos cambiar el valor de descuento, en este caso supera el tope. Tendria que devolvernos el mismo precio final, ya que no se aplicara el descuento.
        dt.setValorDesc(80);
        precioFinal = carrito.getPrecioFinal(dt);
        System.out.println("(Descuento porcentaje con tope de %"+dt.getValorDesc()+") - Precio final del carrito de " + nombreCliente + ": $" + precioFinal); //Funciona.
        //Pero si cambiamos el descuento con un valor de descuento menor al tope, entonces si lo cambiara.
        dt.setValorDesc(valorDescPorcentaje);
        precioFinal = carrito.getPrecioFinal(dt);
        //Tendria que dar el mismo valor que la linea 59, ya que es el mismo porcentaje, por lo que aplicara el mismo descuento.
        System.out.println("(Descuento porcentaje con tope de %"+dt.getValorDesc()+") - Precio final del carrito de " + nombreCliente + ": $" + precioFinal); //Funciona.
    }
}
