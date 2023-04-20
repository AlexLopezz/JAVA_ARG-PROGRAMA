import java.util.Scanner;

public class Excercise2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //Importamos la clase Scanner para leer datos del usuario.
        //Inicializamos las variables de entrada y variables que nos pueden llegar a servir.
        int ingresos=0, cantVehiculos=0, cantInmuebles=0;
        boolean poseeEmbarcacion=false,
                poseeAeronave=false,
                esTitularActivos=false,
                perteneceIngresosAltos=false,
                antigMenor5=false;

        System.out.print("a) Digite sus ingresos: $");
        ingresos = read.nextInt(); //Leemos el monto ingresado por el usuario
        read.nextLine(); //Esto para evitar que salte a la siguiente pregunta(Linea 23) debido al problema que hay cuando despues de un nextInt() hay un nextLine(): https://manolohidalgo.com/error-nextint-seguido-de-nextline-en-java/
        System.out.print("¿ Tiene algun vehiculo a su nombre? Digite 'si'/nCualquier " +
                "letra para 'no'\nRespuesta: ");
        boolean respuesta = read.nextLine().equalsIgnoreCase("si"); //Registramos el si(true)/no(false)

        if(respuesta) { //Si responde que si, entonces procedemos a preguntar acerca los vehiculos:
            System.out.print("Ingrese(en numeros) la cantidad de vehiculos que "+
                    "tiene: ");
            cantVehiculos = read.nextInt(); //Registramos la cantidad de vehiculos que tiene
            read.nextLine();
            System.out.print("¿Algunos de esos vehiculos tiene una antiguedad menor" +
                    " a 5 años? Digite 'si'/Cualquier letra para 'no'.\nRespuesta: ");
            antigMenor5 = read.nextLine().equalsIgnoreCase("si"); //Registramos la antiguedad del total de esos vehiculos.
        }
        System.out.print("Digite la cantidad de inmuebles a su nombre: ");
        cantInmuebles = read.nextInt(); //Registramos la cantidad de inmuebles.
        read.nextLine();
        System.out.print("¿Posee alguna Embarcacion? Digite 'si'/Cualquier letra"+
                " para 'no'.\nRespuesta: ");
        poseeEmbarcacion = read.nextLine().equalsIgnoreCase("si"); //Registramos si tiene embarcacion
        System.out.print("¿Posee alguna Aeronave? Digite 'si'/Cualquier letra para "+
        "'no'.\nRespuesta: ");
        poseeAeronave = read.nextLine().equalsIgnoreCase("si"); //Registramos si tiene alguna aeronave.
        System.out.print("¿ Es titular de activos? Digite 'si'/Cualquier letra para "+
        "'no'.\nRespuesta: ");
        esTitularActivos = read.nextLine().equalsIgnoreCase("si"); //Y por ultimo, registramos si es titular de activos.

        //Empezamos a evaluar si pertenece o no, a las personas con ingresos altos:
        if(ingresos > 489083 || (cantVehiculos > 3
                && antigMenor5) || cantInmuebles > 3
                || (poseeEmbarcacion || poseeAeronave || esTitularActivos)){
            perteneceIngresosAltos=true;
        } //Por defecto, esta en false, por lo que solo evaluamos si cumple para ser una persona con ingresos altos...

        String salida = perteneceIngresosAltos? "Usted pertenece al segmento de "+
        "ingresos altos" : "Usted NO Pertenece al segmento de ingresos altos";

        System.out.println(salida); //Notificamos por consola, si pertenece o no a ingresos altos.

    }
}
