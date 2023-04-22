import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excercise1 {
    public static void main(String[] args) throws IOException {
        String ruta = System.getProperty("user.dir") + "\\clase_14\\src\\main\\resources\\file.txt";
        String regex1 = "(\\+54 [0-9]{2,4} [0-9]{6,8}$)";
        mostrarLineasRegulares(ruta, regex1);
    }
    static void mostrarLineasRegulares(String ruta, String regex) throws IOException {
        List<String> fileContent = Files.readAllLines(Paths.get(ruta));
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        int linea = 1;
        for (String content : fileContent){
            Matcher match = pattern.matcher(content);
            if(match.find()){
                System.out.println("Linea "+linea+": Corresponde con la expresion regular. Matcheado: "+content);
            }else{
                System.out.println("Linea "+linea+": NO Corresponde con la expresion regular. Texto: "+content);
            }
            linea++;
        }
    }
}
