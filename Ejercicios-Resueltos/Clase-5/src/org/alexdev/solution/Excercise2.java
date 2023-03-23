package org.alexdev.solution;

import org.alexdev.classSolution.CarritoCompra;
import org.alexdev.classSolution.ItemCarrito;
import org.alexdev.classSolution.Persona;
import org.alexdev.classSolution.Producto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Excercise2 {
    public static void main(String[] args) throws IOException {
        ItemCarrito[] items = new ItemCarrito[3]; //Creamos una coleccion para almacenar los 'productos comprados' ...
        String ruta = "D:\\JAVA-Curso_ARG-PROGRAMA\\Ejercicios\\Resueltos\\Clase-5\\src\\org\\alexdev\\utility\\fileIn.txt"; //Ruta destinada para leer el archivo con los productos comprados...

        Path getPath = Paths.get(ruta); //Obtenemos el path del archivo, para luego leerlo. Lo dejamos en una variable, debido a que se utilizara mas de una vez. Para no repetir codigo.
        String fileIn = String.valueOf(Files.readAllLines(getPath)); //Obtenemos el contenido del archivo casteado a String por el momento.

        //Debemos reemplazar los corchetes y comas, que vienen por defecto cuando casteamos a String el archivo:
        fileIn = fileIn.replace("[", "")
                .replace("]", "")
                .replace(",", "");

        // System.out.println("fileIn = " + fileIn); Verificando si quedo como esperabamos...
        String[] itemsArray = fileIn.split(" "); //Convertimos todos los datos en un elemento de una coleccion de String, separados por el espacio.

        //Completamos manualmente cada item del carrito de forma estatica / manual.
        items[0] = new ItemCarrito(
                new Producto(
                        itemsArray[2],
                        Double.parseDouble(itemsArray[1])
                ), Integer.parseInt(itemsArray[0])
        );
        items[1] = new ItemCarrito(
                new Producto(
                        itemsArray[5],
                        Double.parseDouble(itemsArray[4])
                ), Integer.parseInt(itemsArray[3])
        );
        items[2] = new ItemCarrito(
                new Producto(
                        itemsArray[8],
                        Double.parseDouble(itemsArray[7])
                ), Integer.parseInt(itemsArray[6])
        );

        //Agregamos al carrito de compra los items, y el cliente quien  lo compro.
        CarritoCompra carritoAlex = new CarritoCompra(new Persona("Alex", "Lopez", "131231231"), items);

        System.out.println(carritoAlex); //Verificamos los datos del carrito
        System.out.println("carrito.getPrecioFinal() == "+carritoAlex.getPrecioFinal()); //obtenemos el precio final con el metodo de la clase.
    }
}
