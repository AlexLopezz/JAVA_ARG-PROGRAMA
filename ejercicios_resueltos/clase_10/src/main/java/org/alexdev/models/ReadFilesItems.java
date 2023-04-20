package org.alexdev.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFilesItems {
    private String ruta; //Le pasamos la ruta

    public ReadFilesItems() {
    }

    public ReadFilesItems(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    //Obtendremos cada dato del archivo como un elemento del arreglo String.
    public String[] getItemsFile() throws IOException {
        Path rutaCSV = Paths.get(ruta);

        return String.valueOf(Files.readAllLines(rutaCSV))
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n")
                .replace(";", "\n")
                .split("\n");
    }
}
