package org.alexdev.solution;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;


public class Excercise3 {
    public static void main(String[] args) throws IOException {
        String salida = "D:\\JAVA-Curso_ARG-PROGRAMA\\Ejercicios\\Resueltos\\Clase-4\\src\\org\\alexdev\\utility\\fileOut.txt";
        String entrada = "D:\\JAVA-Curso_ARG-PROGRAMA\\Ejercicios\\Resueltos\\Clase-4\\src\\org\\alexdev\\utility\\fileIn.txt";
        int desplazamiento = 1;

        String codif = codificacion(entrada, desplazamiento);
        System.out.println("codificado con desplazamiento en "+desplazamiento+": " + codif);
        guardarFile(salida, codif);
        String decof = decodificacion(salida, desplazamiento);
        System.out.println("decoficado: " + decof);
        

    }
    public static String codificacion(String path, int desp) throws IOException{
        String fileIn = Arrays.toString(Files.readAllLines(Paths.get(path)).toArray(new String[0]));
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        //Iteraremos con dos for anidados
        for (int i = 0; i< fileIn.length(); i++) { //El primer for iterara sobre la variable 'fileIn'
            if(fileIn.charAt(i) == ' ') { //Si es igual a un espacio, entonces...
                sb.append("a"); //Almacenaremos una 'a', ya que en el ejemplo de la consigna esta indicada asi.
            }
            for (int j = 0; j < abecedario.length(); j++) { //El segundo for iterara sobre la variable 'abecedario'
                // Por lo que en el segundo for, compararemos si hay alguna coincidencia letra por letra del texto con el abecedario:
                if(fileIn.charAt(i) == abecedario.charAt(j)){ //Si son iguales, significa que coinciden entonces entramos a la condicion.
                    if(abecedario.charAt(j) == abecedario.charAt(abecedario.length()-1)){ //Hay que verificar si es la ultima letra del abecedario la coincidencia( z ), ya que si lo es, debemos empezar desde a + desp.
                        int aux = j - (abecedario.length()); //Si entra a la condicion, entonces realizamos el calculo entre j - length() del 'abc', nos dara -1, que es lo importante ya que sumando el desplazamiento nos dara la letra exacta.
                        sb.append(abecedario.charAt(aux+desp)); //Almacenamos el caracter resultante al StringBuilder().
                    }else {
                        sb.append(abecedario.charAt(j + desp)); //Si hay coincidencia con cualquier letra, entonces no hay problema, almacenamos la letra con el desplazamiento.
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void guardarFile(String path, String texto) {
        try {
            Files.write(Paths.get(path), (texto+System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            System.out.println("Archivo guardado correctamente.");
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo.");
        }
    }
    public static String decodificacion(String path, int desp) throws IOException{
        String fileOut = Arrays.toString(Files.readAllLines(Paths.get(path)).toArray(new String[0]));
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        //Iteraremos con dos for anidados
        for (int i = 0; i< fileOut.length(); i++) { //El primer for iterara sobre la variable 'fileIn'
            for (int j = 0; j < abecedario.length(); j++) { //El segundo for iterara sobre la variable 'abecedario'
                // Por lo que en el segundo for, compararemos si hay alguna coincidencia letra por letra del texto con el abecedario:
                if(fileOut.charAt(i) == abecedario.charAt(j)){ //Si son iguales, significa que coinciden entonces entramos a la condicion.
                    if(abecedario.charAt(j) == abecedario.charAt(0)){ //Hay que verificar si es la ultima letra del abecedario la coincidencia( z ), ya que si lo es, debemos empezar desde a + desp.
                        int aux = abecedario.length() - desp; //Si entra a la condicion, entonces realizamos el calculo entre j - length() del 'abc', nos dara -1, que es lo importante ya que sumando el desplazamiento nos dara la letra exacta.
                        sb.append(abecedario.charAt(aux)); //Almacenamos el caracter resultante al StringBuilder().
                    }else {
                        sb.append(abecedario.charAt(j - desp)); //Si hay coincidencia con cualquier letra, entonces no hay problema, almacenamos la letra con el desplazamiento.
                    }
                }
            }
        }
        return sb.toString();
    }


}
