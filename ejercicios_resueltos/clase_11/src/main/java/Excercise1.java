import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) throws IOException {
        //Siempre tendra el nombre del usuario en cuestion que ingresara el texto.
        String usuario = "Alex";
        //Servira para identificar que 'decision' ingreso el usuario..
        int decision = 0;
        //Con el Scanner leemos los que nos digita el usuario.
        Scanner lector = new Scanner(System.in);
        //Le presentamos(por pantalla) las posibles opciones que puede realizar en el programa el usuario.
        System.out.println("- - - - - - - - - - - - -");
        System.out.print("¿Que desea realizar?\n1.Escribir texto en chat\n2.Mostrar chat.\n3.Salir\nEliga una opcion: ");
        //Realizamos un try por si el usuario quiere ingresar contenido que no sea numero entero.
        try {
            decision = lector.nextInt();
            lector.nextLine();
            //Dependiendo de la decision del usuario ejecutara el codigo correspondiente:
            switch (decision) {
                case 1 -> {
                    System.out.println("- - - - MENSAJE - - - -");
                    System.out.print(usuario + ": ");
                    String textoChat = lector.nextLine();
                    guardarTextoChat(textoChat);
                }
                case 2 -> {
                    System.out.println("- - - - CHAT - - - -");
                    mostrarChat();
                }
                case 3 -> {
                    limpiarChat();
                    System.exit(0);
                }
                default -> System.out.println("No eligio ninguna de las opciones propuestas...");
            }
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar alguna opcion de las propuestas... (Solo numero, no letras ni texto)");
        }
        main(args);
    }

    /**
     *  Esta funcion guardara texto en un archivo especificado.
     * @param texto el Texto en cuestion que se pretende guardar.
     * @throws IOException Si no se le indica una ruta especifica correcta.
     */
    static void guardarTextoChat(String texto) throws IOException {
        Path rutaPath = Paths.get(System.getProperty("user.dir")+"\\clase_11\\src\\main\\resources\\chat.txt");
        Files.write(rutaPath,(texto+System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
    }

    /**
     *  Esta funcion limpiara el chat, es decir dejara en blanco
     * o sin contenido.
     * @throws IOException Si no se le indica una ruta especifica correcta.
     */
    static void limpiarChat() throws IOException {
        Path rutaPath =  Paths.get(System.getProperty("user.dir")+"\\clase_11\\src\\main\\resources\\chat.txt");
        Files.write(rutaPath,("").getBytes());
    }

    /**
     *  Esta funcion imprimira el contenido del archivo en cuestion.
     * @throws IOException Si no se le indica una ruta especifica correcta.
     */
    static void mostrarChat() throws IOException {
        String ruta = System.getProperty("user.dir")+"\\clase_11\\src\\main\\resources\\chat.txt";
        List<String> chat = Files.readAllLines(Paths.get(ruta));
        if(chat.size() > 0) {
            chat.forEach(System.out::println);
        }else{
            System.out.println("No hay contenido en el chat...");
        }
    }
}

