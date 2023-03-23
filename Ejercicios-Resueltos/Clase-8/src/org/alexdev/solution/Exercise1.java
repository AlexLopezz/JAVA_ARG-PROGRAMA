package org.alexdev.solution;



import org.alexdev.ItemCarritoRepositorio;

import org.alexdev.exceptions.DescuentoCero;
import org.alexdev.exceptions.SinPrecioDescuento;
import org.alexdev.models.CarritoCompra;
import org.alexdev.models.ItemCarrito;
import org.alexdev.models.descuento.DescuentoPorcentaje;
import org.alexdev.utility.classUtility.ReadFilesItems;

import java.io.IOException;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) throws IOException, SinPrecioDescuento, DescuentoCero {
        //Especificamos em String la ruta donde esta el CSV.
        String rutaCSV = System.getProperty("user.dir") + "\\Clase-8\\src\\org\\alexdev\\resources\\itemsProducto.csv";
        //Instanciamos un objeto repositorio para obtener los datos del archivo a una lista de items carrito
        ItemCarritoRepositorio icr = new ItemCarritoRepositorio();
        //Instanciamos readfiles para poder obtener los datos del archivo, indicandole el path.
        ReadFilesItems rf = new ReadFilesItems(rutaCSV);


        CarritoCompra carritoAlex = new CarritoCompra(); //Creamos un carrito de comprar para obtener el precio final

        List<ItemCarrito> auxItems = icr.getItem(rf.getItemsFile()); //Aqui obtenemos los items del archivo y lo convertimos a una lista de items.
        carritoAlex.setItems(auxItems); //Especificamos la lista de items al objeto carrito.

        //Probamos la excepcion: SinPrecioDescuento. Si el precio del carrito es mayor a 0, debera indicarnos la excepcion.
        System.out.println(carritoAlex.getPrecioFinal(new DescuentoPorcentaje(30d)));


        //Probemos con otro archivo csv:
        rf.setRuta(System.getProperty("user.dir")+"\\Clase-8\\src\\org\\alexdev\\resources\\itemsProductos2.csv");
        //Reutilizamos la lista de items para almacenar esta vez, lo que tiene el segundo archivo.
        auxItems = icr.getItem(rf.getItemsFile());
        //Especificamos esta vez la lista de items del segundo archivo al carrito
        carritoAlex.setItems(auxItems);

        //Probamos la excepcion: DescuentoCero: Si el precio final con descuento es menor a 0, debera indicarnos una excepcion.
        System.out.println(carritoAlex.getPrecioFinal(new DescuentoPorcentaje(250d)));

    }
}