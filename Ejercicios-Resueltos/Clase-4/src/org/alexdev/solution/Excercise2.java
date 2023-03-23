package org.alexdev.solution;


import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Excercise2 {
    public static void main(String[] args) throws IOException {
        System.out.println("==== 2.a =====");
        //Especificamos el path:
        String path = "D:\\JAVA-Curso_ARG-PROGRAMA\\Ejercicios\\Resueltos\\Clase-4\\src\\org\\alexdev\\utility\\file.txt";
        int sumaTotal = sumaArchivos(path);

        String salida = sumaTotal != 0? "La suma total es: "+ sumaTotal : "No se puede realizar la suma, el archivo contiene caracteres.";
        System.out.println(salida);

        int multTotal = multiplicacionArchivos(path);

        salida = multTotal != 1? "La multiplicacion de todos los numeros es de: "+multTotal: "No se puede realizar la multiplicacion, el archivo contiene caracteres.";
        System.out.println(salida);

    }
    private static int sumaArchivos(String path) throws IOException{
        List<String> numFiles = Files.readAllLines(Paths.get(path));
        int suma = 0;

        for (String number : numFiles) {
            suma += Integer.parseInt(number);
        }

        return suma;
    }
    private static int multiplicacionArchivos(String path) throws IOException{
        List<String> numFiles = Files.readAllLines(Paths.get(path));
        int multiplicacion=1;

        for (String number : numFiles) {
            multiplicacion*= Integer.parseInt(number);
        }

        return multiplicacion;
    }
}
