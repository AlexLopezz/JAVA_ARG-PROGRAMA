public class Exercise1 {
    public static void main(String[] args) {

        System.out.println("============== 1.a ================");
        // Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String:
        String texto = "Te doy la bienvenida a la clase de JAVA clase 3!";
        System.out.println("texto: " + texto);
        char letra = 'a';
        System.out.println("letra elegida: " + letra);
        int cantidadLetra = 0;

        /* Forma mas simple:
        for(int i =0; i < texto.length(); i++){
            if(texto.toLowerCase().charAt(i) == letra ){
                cantidadLetra++;
            }
        } */

        String[] letras = texto.split(" ");
        for(int i = 0; i < letras.length; i++ ){
            for(int j=0; j < letras[j].length(); j++) {
                if(letras[j].equals(String.valueOf(letra))){
                    cantidadLetra++;
                }
            }


        }


        System.out.println("La cantidad de veces que aparece la letra \""+letra+"\" es: "+cantidadLetra);

        System.out.println("============== 1.b ================");
        //Dados 3 números y un orden (ascendente o decreciente) que ordene los mismos y los retorne en un vector de 3.
        String orden = "ASC"; //ASC o DESC para dar un ordenamiento.
        System.out.println("orden: " + orden);

        //Inicializamos los tres numeros de entrada:
        int numero=10,
            numero2=50,
            numero3=9;

        //Utilizando el metodo de ordenamiento burbuja, almacenaremos a los numeros segun el orden:
        int[] arryResultante = Bubblesort(numero, numero2, numero3, orden);

        //Verificamos las posiciones de los numeros con un for each.
        for(int i: arryResultante) {
            System.out.println(i);
        }


        //dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado.
        System.out.println("============== 1.c ================");

        //Inicializamos el vector con elementos random.
        int[] numeros = {
                25,
                123,
                74,
                242,
                764,
                323,
                114
        };

        //Inicializamos la variable X con un valor random.
        int numeroX = 230;

        //Realizamos la sumatoria total de aquellos numeros que sean mayores a X.
        int sumaTotal = sumaX(numeros, numeroX);
        System.out.println("La suma total de los numeros mayores a "+numeroX+ " es de: "+ sumaTotal); //Mostramos por consola la sumatoria total.

    }

    //Funciones estaticas que nos serviran para resolver el problema de ordenamiento( Bubblesort() ) y la sumatoria( sumaX())
    public static int[] Bubblesort(int num, int num2, int num3, String ord){
        //Metodo burbuja.
        int[] arry = {num, num2, num3};
        switch (ord) {
            case "ASC" -> {
                for (int i = 0; i < arry.length - 1; i++) {
                    int temp;
                    for (int j = 0; j < arry.length - 1; j++) {
                        if (arry[j] > arry[j + 1]) {
                            temp = arry[j];
                            arry[j] = arry[j + 1];
                            arry[j + 1] = temp;
                        }
                    }
                }
            }
            case "DESC" -> {
                for (int i = 0; i < arry.length - 1; i++) {
                    int temp;
                    for (int j = 0; j < arry.length - 1; j++) {
                        if (arry[j] < arry[j + 1]) { //  10 < 50
                            temp = arry[j];
                            arry[j] = arry[j + 1];
                            arry[j + 1] = temp;
                        }
                    }
                }
            }
        }
        return arry;
    }
    public static int sumaX(int[] numerosArry, int numX){
        int suma = 0;
        for(int n : numerosArry){
            if(n > numX){
                suma+=n;
            }
        }
        return suma;
    }
}
