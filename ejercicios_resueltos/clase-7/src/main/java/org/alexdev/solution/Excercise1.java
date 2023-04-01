package org.alexdev.solution;

import org.alexdev.solution.models.CarritoCompra;
import org.alexdev.solution.models.ItemCarrito;
import org.alexdev.solution.models.Producto;
import org.alexdev.solution.models.descuento.DescuentoFijo;
import org.alexdev.solution.models.descuento.DescuentoPorcentaje;
import org.alexdev.solution.models.descuento.DescuentoPorcentajeConTope;
import org.alexdev.solution.models.enumeration.TIPO_DESCUENTO;
import org.alexdev.solution.models.persona.Cliente;

public class Excercise1 {
    public static void main(String[] args) {
        //Creamos un cliente para vincularlo con un carrito
        Cliente cliente = new Cliente("45687942", "Alex", "Lopez");

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


        int descuentoMontoFijo = 200; //Creamos un monto ficticio para el ejemplo del descuento fijo.
        double descuentoPorcentaje = 20; //Creamos un porcentaje ficticio para el ejemplo del descuento con procentaje.

        DescuentoFijo descFijo = new DescuentoFijo(descuentoMontoFijo); //Instanciamos un nuevo objeto para la demostracion del descuento fijo.
        DescuentoPorcentaje descPorcentaje = new DescuentoPorcentaje(descuentoPorcentaje);


        String tipoDescuento = String.valueOf(TIPO_DESCUENTO.FIJO); //Demostracion con descuento fijo.

        if(tipoDescuento.equals(String.valueOf(TIPO_DESCUENTO.FIJO))){
            System.out.println("Precio final (Con descuento de monto fijo): $"+carrito.getPrecioFinal(descFijo));
        }else if(tipoDescuento.equals(String.valueOf(TIPO_DESCUENTO.PORCENTAJE))){
            System.out.println("Precio final (Con descuento % porcentaje): $"+carrito.getPrecioFinal(descPorcentaje));
        }
    }
}
