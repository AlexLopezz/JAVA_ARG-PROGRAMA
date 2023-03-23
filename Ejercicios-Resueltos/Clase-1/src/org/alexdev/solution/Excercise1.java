package org.alexdev.solution;

public class Excercise1 {
    public static void main(String[] args) {
        // Especificamos como constantes las cotas inferior y superior.
        final int NUMBER_START = 10;
        final int NUMBER_END = 20;
        // Inicializamos una variable aux(auxiliar) donde tendra como valor, el valor de la cota inferior. Y se seteara para cada consigna.
        int aux = NUMBER_START;

        //1a. Utilizando la sentencia while, imprima todos los números entre 2 variables “a” y “b”.
        System.out.println("===== 1.a) =====");
        System.out.printf("Imprimiendo valores entre a(%d) y b(%d)\n", NUMBER_START, NUMBER_END);
        while (aux <= NUMBER_END) {
            System.out.println(aux);
            aux++; //Es importante incrementar aux al final del bucle para prevenir un bucle infinito.
        }

        aux= NUMBER_START; //Es importante setear la variable auxiliar. De modo de poder realizar la iteracion para las siguientes consignas:

        //b. A lo anterior, solo muestre los números pares
        System.out.println("===== 1.b) =====");
        System.out.printf("Numeros pares entre el rango a(%d) y b(%d)\n", aux, NUMBER_END);
        while (aux <= NUMBER_END){
            if(aux % 2 == 0){ //Si aux dividido por 2 da como resto 0, entonces significa que es par.
                System.out.println(aux);
            }
            aux++; //Recuerda: Incrementar la variable aux para prevenir un bucle infinito, tiene que ir al final del ambito del while.
        }


        //c. A lo anterior, con una variable extra, elija si se deben mostrar los números pares o impares
        aux= NUMBER_START;
        boolean esPar = false; //Con esta variable verificaremos si queremos mostrar pares(true)/impares(false). Se debe modificar en tiempo de compilacion.
        System.out.println("===== 1.c) =====");
        System.out.println("es par?: " + esPar);
        if(esPar){
            System.out.println("Es par.");
            while (aux <= NUMBER_END){
                if(aux % 2 == 0){
                    System.out.println(aux);
                }
                aux++;
            }
        }else{ //Como es un booleano, si no es true entonces es false... Y por lo tanto, tiene sentido mostrar los impares.
            System.out.println("Es impar");
            while (aux <= NUMBER_END){
                if(aux % 2 != 0){
                    System.out.println(aux);
                }
                aux++;
            }
        }

        //d. Utilizando la sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden
        System.out.println("===== 1.d) =====");
        aux= NUMBER_START;
        System.out.println("Consigna b, invertido con bucle for.");
        for(int i=NUMBER_END; i >= NUMBER_START; i--){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}