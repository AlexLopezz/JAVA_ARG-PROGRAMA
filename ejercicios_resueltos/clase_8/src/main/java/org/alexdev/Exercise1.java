package org.alexdev;

import org.alexdev.exceptions.SinPrecioDescuento;
import org.alexdev.repository.ItemCarritoRepositorio;
import org.alexdev.models.descuento.*;
import org.alexdev.models.*;
import resources.ReadFilesItems;

import java.io.IOException;
import java.util.List;


public class Exercise1 {
    public static void main(String[] args) throws IOException, SinPrecioDescuento {
        //Variables de entrada
        double precioFinal = 0;
        CarritoCompra carritoAlex = new CarritoCompra();
        ReadFilesItems rf = new ReadFilesItems();
        ItemCarritoRepositorio icr = new ItemCarritoRepositorio();


        //Especificamos en String la ruta donde esta el CSV.
        String rutaCSV = System.getProperty("user.dir") + "\\clase_8\\src\\main\\java\\resources\\itemsProducto.csv";
        rf.setRuta(rutaCSV);

        //Aqui obtenemos los items del archivo y lo convertimos a una lista de items.
        List<ItemCarrito> itemsCarrito = icr.getItem(rf.getItemsFile());
        //Especificamos la lista de items al objeto carrito.
        carritoAlex.setItemsCarrito(itemsCarrito);

        //Almacenamos en una variable de tpo double el valor final del carrito
        precioFinal = carritoAlex.getPrecioFinal();
        //Mostramos por pantalla
        System.out.println("(archivo 1)Precio final carrito: $"+precioFinal);


        //Probemos con otro archivo csv, de otro tamaño, para verificar que funcione de manera correcta la lista...
        rf.setRuta(System.getProperty("user.dir")+"\\clase_8\\src\\main\\java\\resources\\itemsProductos2.csv");
        //Limpiamos el carrito para agregar otros productos
        itemsCarrito.clear();
        //Reutilizamos la lista de items para almacenar esta vez, lo que tiene el segundo archivo.
        itemsCarrito = icr.getItem(rf.getItemsFile());
        //Especificamos esta vez la lista de items del segundo archivo al carrito.
        carritoAlex.setItemsCarrito(itemsCarrito);


        precioFinal = carritoAlex.getPrecioFinal();
        System.out.println("(archivo 2)Precio final carrito: $"+precioFinal);


        rf.setRuta(System.getProperty("user.dir")+"\\clase_8\\src\\main\\java\\resources\\itemsProductoException.csv");
        //Reutilizamos la lista de items para almacenar esta vez, lo que tiene el archivo.
        itemsCarrito.clear();
        itemsCarrito = icr.getItem(rf.getItemsFile());
        carritoAlex.setItemsCarrito(itemsCarrito);


        //Probamos la excepcion: DescuentoCero. -- Si se quiere probar la otra excepcion(linea 63) debe comentar esta linea y la linea siguiente
        System.out.println(carritoAlex.getPrecioFinal(new DescuentoPorcentaje(40d)));


        //Cambiamos de productos: Cada producto valdra 250, en total son 3 productos, por lo cual serian $750
        for (ItemCarrito ic : carritoAlex.getItemsCarrito()){
            ic.setProducto(
                    new Producto(
                            "Alfajor",
                            250)
            );
        }
        //Probamos la excepcion: SinPrecioDescuento.
        System.out.println(carritoAlex.getPrecioFinal(new DescuentoFijo(1500)));
    }
}