import models.CarritoCompra;
import models.ItemCarrito;
import models.Persona;
import models.Producto;
import models.persona.Cliente;

public class Excercise1 {
    public static void main(String[] args) {
        //Creacion de las personas
        Cliente juancito = new Cliente(
                "Juan",
                "Perez",
                "32123123");
        Cliente alex = new Cliente("Alex",
                "Sanchez",
                "32123123");

        //Creacion de los carritos de ambas personas:
        ItemCarrito[] itemsJuan = {
                new ItemCarrito(
                        new Producto(
                                "Colgate",
                                250),
                        2),
                new ItemCarrito(
                        new Producto(
                                "IPhone 11",
                                550),
                        1),
                new ItemCarrito(
                        new Producto(
                                "Lenovo TAB A7",
                                450),
                        1)
        };
        ItemCarrito[] itemsAlex = {
                new ItemCarrito(
                        new Producto(
                                "Monitor ASUS B231",
                                300),
                        1),
                new ItemCarrito(
                        new Producto(
                                "Samsung s20 FE",
                                650),
                        1),
                new ItemCarrito(
                        new Producto(
                                "Mouse Logitech g203",
                                80),
                        2)
        };

        CarritoCompra carritoJuan = new CarritoCompra(juancito, itemsJuan);
        CarritoCompra carritoAlex = new CarritoCompra(alex, itemsAlex);

        System.out.println("Total de la compra del carrito de "+juancito.getNombre()+": $"+ carritoJuan.getPrecioFinal());
        System.out.println("Total de la compra del carrito de "+alex.getNombre()+" $"+carritoAlex.getPrecioFinal());
    }
}
