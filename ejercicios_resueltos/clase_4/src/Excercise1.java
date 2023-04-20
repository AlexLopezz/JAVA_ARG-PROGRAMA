import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) {
        System.out.println("===== 1.a =====");
        //Variables de entrada:
        int numero = 12, numero2 = 230, numero3=128;
        char orden = 'D'; //ASCENDENTE -> A DESCENDENTE -> D

        int[] numerosOrdenados = orden(numero, numero2, numero3, orden);
        mostrarElementos(numerosOrdenados);

        System.out.println("===== 1.b =====");
        int i=0;
        Scanner read = new Scanner(System.in);
        while (i < numerosOrdenados.length){
            System.out.print("Ingrese un numero("+(i+1)+"): ");
            numerosOrdenados[i] = Integer.parseInt(read.nextLine());
            i++;
        }
        System.out.print("Ingrese 'A'(Ascendente) o 'D'(Descendente) para dar un orden a los numeros ingresados: ");
        orden = read.nextLine().charAt(0);

        int[] numerosOrdenados2 = orden(numerosOrdenados, orden);
        mostrarElementos(numerosOrdenados2);

    }

    private static int[] orden(int num, int num2, int num3, char ord){
        int[] numOrdenados = { num, num2, num3};

        switch(ord) {
                case 'A' -> {
                    for (int i = 1; i < numOrdenados.length; i++) {
                        int aux;
                        for (int j = 0; j < numOrdenados.length - 1; j++) {
                            if (numOrdenados[j] > numOrdenados[j + 1]) {
                                aux = numOrdenados[j];
                                numOrdenados[j] = numOrdenados[j+1];
                                numOrdenados[j+1] = aux;
                            }
                        }
                    }
                }
            case 'D' -> {
                for (int i = 1; i < numOrdenados.length; i++) {
                    int aux;
                    for (int j = 0; j < numOrdenados.length - 1; j++) {
                        if (numOrdenados[j] < numOrdenados[j + 1]) {
                            aux = numOrdenados[j];
                            numOrdenados[j] = numOrdenados[j+1];
                            numOrdenados[j+1] = aux;
                        }
                    }
                }
            }
        }
        return numOrdenados;
    }
    private static int[] orden(int[] numOrdenados, char ord){


        switch(ord) {
                case 'A' -> {
                    for (int i = 1; i < numOrdenados.length; i++) {
                        int aux;
                        for (int j = 0; j < numOrdenados.length - 1; j++) {
                            if (numOrdenados[j] > numOrdenados[j + 1]) {
                                aux = numOrdenados[j];
                                numOrdenados[j] = numOrdenados[j+1];
                                numOrdenados[j+1] = aux;
                            }
                        }
                    }
                }
            case 'D' -> {
                for (int i = 1; i < numOrdenados.length; i++) {
                    int aux;
                    for (int j = 0; j < numOrdenados.length - 1; j++) {
                        if (numOrdenados[j] < numOrdenados[j + 1]) {
                            aux = numOrdenados[j];
                            numOrdenados[j] = numOrdenados[j+1];
                            numOrdenados[j+1] = aux;
                        }
                    }
                }
            }
        }
        return numOrdenados;
    }
    private static void mostrarElementos(int[] array){
        for(int n : array){
            System.out.println(n);
        }
    }
}
