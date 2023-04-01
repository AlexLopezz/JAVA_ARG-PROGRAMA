package org.alexdev.solution;

import org.alexdev.solution.models.CarritoCompra;
import org.alexdev.solution.models.ItemCarrito;
import org.alexdev.solution.models.Producto;
import org.alexdev.solution.models.descuento.DescuentoPorcentajeConTope;
import org.alexdev.solution.models.persona.Cliente;

public class Excercise2 {
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

        double topePorcentaje = 30; //Indicamos el tope del porcentaje permitido, en este caso sera lo que tenga el valor de la variable 'topePorcentaje'

        //Una vez definido el tope, no podremos sobrepasarlo cuando lo instanciamos como un nuevo objeto. Se podra cambiar el tope
        DescuentoPorcentajeConTope descuentoPorcentajeConTope = new DescuentoPorcentajeConTope(topePorcentaje);

        //Probando si funciona:
        descuentoPorcentajeConTope.setPorcentaje(50d); //Intentando cambiar el tope de descuento a 50.
        System.out.println(descuentoPorcentajeConTope.getPorcentaje()); //Tendria que quedar en el tope(30). debido a que sobrepasa el tope.

        descuentoPorcentajeConTope.setPorcentaje(28d);
        System.out.println(descuentoPorcentajeConTope.getPorcentaje()); //Tendria que quedar en el tope(28). ya que no lo sobrepasa.

        System.out.println("Precio final (Con descuento % porcentaje CON TOPE): $"+carrito.getPrecioFinal(descuentoPorcentajeConTope)); //Efectivamente funciona.
    }
}
