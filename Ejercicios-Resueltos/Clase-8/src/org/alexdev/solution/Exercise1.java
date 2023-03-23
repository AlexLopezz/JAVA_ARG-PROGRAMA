package org.alexdev.solution;



import org.alexdev.ItemCarritoRepositorio;
import org.alexdev.exceptions.SinPrecioDescuento;
import org.alexdev.models.CarritoCompra;
import org.alexdev.models.ItemCarrito;
import org.alexdev.models.descuento.DescuentoPorcentaje;
import org.alexdev.models.persona.Cliente;
import org.alexdev.utility.classUtility.ReadFilesItems;

import java.io.IOException;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        String rutaCSV = System.getProperty("user.dir") + "\\Clase-8\\src\\org\\alexdev\\resources\\itemsProducto.csv";
        ItemCarritoRepositorio icr = new ItemCarritoRepositorio();
        ReadFilesItems rf = new ReadFilesItems(rutaCSV);


        CarritoCompra carritoAlex = new CarritoCompra();

        List<ItemCarrito> items = icr.getItem(rf.getItemsFile());
        carritoAlex.setItems(items);



        //rf.setRuta(System.getProperty("user.dir")+"\\Clase-8\\src\\org\\alexdev\\resources\\itemsProductos2.csv");

        //carritoAlex.addItems(rf.getItemsFile());


        //Probamos las excepciones: SinPrecioDescuento
        try {
            System.out.println(carritoAlex.getPrecioFinal(new DescuentoPorcentaje(30d)));
        } catch (SinPrecioDescuento e) {
            e.printStackTrace();
        }

    }
}