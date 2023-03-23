package org.alexdev.solution;

public class Exercise2 {
    public static void main(String[] args) {
        //Variables de entrada:
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String evaluarTexto = "hola que tal";
        int desp = 1; // Con esta variable, verificamos el desplazamiento que hay con el abecedario.

        //con desplazo de 1:
        System.out.println("resultado( desplazo "+desp+" ) = " + desplazar(abecedario, evaluarTexto, desp));

        desp = 2;
        //con desplazo de 2:
        System.out.println("resultado( desplazo "+desp+" ) = " + desplazar(abecedario, evaluarTexto, desp));

    }
    public static String desplazar(String abc, String texto, int desplazamiento){
       StringBuilder sb = new StringBuilder(); //Utilizamos un StringBuilder() debido a que almacenaremos caracter por caracter, y para ahorrar memoria ya que es mutable: https://decodigo.com/2012/09/cual-es-la-diferencia-entre-string.html

        //Iteraremos con dos for anidados
        for (int i = 0; i< texto.length(); i++) { //El primer for iterara sobre la variable 'texto'
           if(texto.charAt(i) == ' ') { //Si es igual a un espacio, entonces...
                sb.append("a"); //Almacenaremos una 'a', ya que en el ejemplo de la consigna esta indicada asi.
           }
            for (int j = 0; j < abc.length(); j++) { //El segundo for iterara sobre la variable 'abc'
               // Por lo que en el segundo for, compararemos si hay alguna coincidencia letra por letra del texto con el abecedario:
               if(texto.charAt(i) == abc.charAt(j)){ //Si son iguales, significa que coinciden entonces entramos a la condicion.
                   if(abc.charAt(j) == abc.charAt(abc.length()-1)){ //Hay que verificar si es la ultima letra del abecedario la coincidencia( z ), ya que si lo es, debemos empezar desde a + desp.
                       int aux = j - (abc.length()); //Si entra a la condicion, entonces realizamos el calculo entre j - length() del 'abc', nos dara -1, que es lo importante ya que sumando el desplazamiento nos dara la letra exacta.
                       sb.append(abc.charAt(aux+desplazamiento)); //Almacenamos el caracter resultante al StringBuilder().
                   }else {
                       sb.append(abc.charAt(j + desplazamiento)); //Si hay coincidencia con cualquier letra, entonces no hay problema, almacenamos la letra con el desplazamiento.
                   }
               }
           }
       }
       return sb.toString(); //Retornamos el String del StringBuilder().
    }
}
