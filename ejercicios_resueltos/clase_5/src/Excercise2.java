

import models.CarritoCompra;
import models.ItemCarrito;
import models.Persona;
import models.Producto;
import models.persona.Cliente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Excercise2 {
    public static void main(String[] args) throws IOException {
        ItemCarrito[] items = new ItemCarrito[3]; //Creamos una coleccion para almacenar los 'productos comprados' ...
        String ruta = System.getProperty("user.dir") + "\\clase_5\\src\\utilities\\fileIn.txt"; //Ruta destinada para leer el archivo con los productos comprados...

        Path getPath = Paths.get(ruta); //Obtenemos el path del archivo, para luego leerlo. Lo dejamos en una variable, debido a que se utilizara mas de una vez. Para no repetir codigo.
        String fileIn = String.valueOf(Files.readAllLines(getPath)); //Obtenemos el contenido del archivo casteado a String por el momento.

        //Obtenemos en un array el String formateado, con toda la data del .txt
        String[] itemsArray = getFormatedArray(fileIn);

        //Completamos cada item del carrito de forma iterativa...
        fillCarrito(items, itemsArray);

        //Agregamos al carrito de compra los items, y el cliente quien  lo compro.
        CarritoCompra carritoAlex = new CarritoCompra(
                new Cliente(
                        "Alex",
                        "Lopez",
                        "131231231"),
                items);

        System.out.println(carritoAlex); //Verificamos los datos del carrito.
        System.out.println("carrito.getPrecioFinal() == $"+carritoAlex.getPrecioFinal()); //obtenemos el precio final con el metodo getPrecioFinal() de la clase.
    }
    private static String[] getFormatedArray(String fileIn) {
        //Debemos reemplazar los corchetes y comas, que vienen por defecto cuando casteamos a String el archivo:
        return  fileIn
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .split(" "); //Convertimos todos los datos en un elemento de una coleccion de String, separados por el espacio.
    }

    private static void fillCarrito(ItemCarrito[] items, String[] itemsTxt) {
        int auxColumns = 0;
        for(int i = 0; i< itemsTxt.length / 3; i++){
            items[i] = new ItemCarrito(
                    new Producto(
                            itemsTxt[auxColumns+2],
                            Double.parseDouble(itemsTxt[auxColumns+1])
                    ),
                    Integer.parseInt(itemsTxt[auxColumns])
            );
            auxColumns+=3;
        }
    }
}
