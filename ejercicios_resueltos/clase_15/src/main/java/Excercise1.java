import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Oferta;
import models.Producto;
import models.ReadFilesItems;
import models.descuento.DescuentoPorcentajeConTope;


import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) throws Exception {
        //Creamos una clase la cual convertira la data de un CSV
        ReadFilesItems rf = new ReadFilesItems(System.getProperty("user.dir")+"\\clase_15\\src\\main\\resources\\file.csv");
        //Variables de entrada: scanner y decision serviran para actuar en base a una decision tomada por el usuario, el cual sera leida por el programa.
        Scanner read = new Scanner(System.in);
        String decision = "";


        //Obtenemos la data del CSV en un array de Strings
        String[] fileCSV = rf.getItemsFile();

        //Convertiremos esa data en un Listado de ofertas...
        List<Oferta> ofertasCSV = convertTextToListOferta(fileCSV);

        //Este bucle terminara cuando el usuario toque cualquier otra tecla que no sea la '1'...
        do {
            System.out.print("¿En que formato desea serializar?\n1. JSON\n2. XML\nElija una opcion de las posibles: ");
            try {
                //Leemos la decision del usuario..
                decision = read.nextLine();
                int auxDecision = Integer.parseInt(decision); //Si se puede 'parsear' a entero, entonces es factible para verificar si eligio entre JSON u XML
                serializeAccordingTo(auxDecision, ofertasCSV);
            } catch (InputMismatchException e) {
                System.out.println("Debe elegir una opcion de las posibles...No ingrese texto, ni caracteres solo el numero que identifica a su opcion..."); //En caso de que no se pueda 'parsear' entonces tratamos la excepcion...
            }

            System.out.print("¿Desea probar de nuevo el codigo?\n1. Si\nCualquier tecla para no.\nDecision: ");
            decision = read.nextLine();
        }while (decision.equals("1"));

        System.out.println("Adios!");
    }

    /**
     *  Este metodo serializa acorde a una decision del usuario.
     * @param decision posibles valores para serializar: 1(JSON) o 2(XML)
     * @param ofertasCSV las ofertas que seran serializadas de acuerdo a la decision del usuario.
     *
     */
    static void serializeAccordingTo(int decision, List<Oferta> ofertasCSV) {
        switch (decision) {
            case 1 -> {
                List<String> jsonOfertasCSV = convertJSON(ofertasCSV);
                jsonOfertasCSV.forEach(System.out::println);
            }
            case 2 -> {
                List<String> xmlOfertasCSV = convertXML(ofertasCSV);
                xmlOfertasCSV.forEach(System.out::println);
            }
            default -> System.out.println("Debe elegir una opcion de las posibles... (En numero)");
        }
    }

    /**
     *  Convierte los datos del Array de String en un listado de Ofertas.
     * @param contentFile Un array con datos de Ofertas en un archivo CSV
     * @return Listado de ofertas, en base a los datos del array
     */
    static List<Oferta> convertTextToListOferta(String[] contentFile){
        List<Oferta> ofertas = new ArrayList<>();
        for(int i=0; i < contentFile.length;){
            if(i != 0){
                ofertas.add(
                        new Oferta(
                                new Producto(
                                        contentFile[i],
                                        Double.parseDouble(contentFile[i+1])
                                ),
                                new DescuentoPorcentajeConTope(
                                        Double.parseDouble(contentFile[i+2]),
                                        Double.parseDouble(contentFile[i+3])
                                ),
                                contentFile[i+4],
                                contentFile[i+5]
                        )
                );
            }
            i+=6;
        }
        return ofertas;
    }

    /**
     *  Convertira en XML un listado de ofertas.
     * @param ofertas Se requiere un listado de ofertas para convertir en XML
     * @return Una lista de String donde estara toda la info del listado de ofertas.
     */
    static List<String> convertXML(List<Oferta> ofertas) {
        List<String> ofertasXML = new ArrayList<>();
        XmlMapper mapper = new XmlMapper();
        ofertas.forEach(
                oferta -> {
                    try {
                        ofertasXML.add(mapper.writeValueAsString(oferta));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        return ofertasXML;
    }
    /**
     *  Convertira en JSON un listado de ofertas.
     * @param ofertas Se requiere un listado de ofertas para convertir en JSON
     * @return Una lista de String donde estara toda la info del listado de ofertas.
     */
    static List<String> convertJSON(List<Oferta> ofertas) {
        List<String> ofertasJSON = new ArrayList<>();
        ObjectMapper objMapper = new ObjectMapper();
        ofertas.forEach(
                oferta -> {
                    try {
                        ofertasJSON.add(
                                objMapper.writeValueAsString(oferta)
                        );
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
        );
        return ofertasJSON;
    }
}
