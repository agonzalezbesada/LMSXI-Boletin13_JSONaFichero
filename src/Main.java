import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();

        // Creamos 2 coches
        Coche coche1 = new Coche("1111 AAA","Ferrari");
        Coche coche2 = new Coche("2222 BBB","Mercedes");

        // Creamos un ArrayList<String> que contendrá los coches
        ArrayList<Coche> coches = new ArrayList<>();


        // Añadimos los coches al ArrayList
        coches.add(coche1);
        coches.add(coche2);

        // Convertimos el ArrayList a JSON
        String json_coches = gson.toJson(coches, ArrayList.class);

        FileWriter file;

        try {
            file = new FileWriter("src\\output.json");
            // Guardamos en fichero el JSON con los coches
            file.write(json_coches);
            file.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        String json_recuperado = "";
        FileReader fileReader;

        try {
            fileReader = new FileReader("src\\output.json");
            int caracter = fileReader.read();

            while (caracter!=-1) {
                json_recuperado += (char) caracter;
                caracter = fileReader.read();
            }

            fileReader.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }


        // Usamos TypeToken, de la libreria Gson, ayuda a extender la información sobre lo que se va a deserializar
        Type cocheListType = new TypeToken<ArrayList<Coche>>() {}.getType();

        // Parseamos el JSON a un ArrayList que contiene coches
        ArrayList<Coche> cochesRecuperados = gson.fromJson(json_recuperado, cocheListType);

        // Comprobamos que se han parseado correctamente
        cochesRecuperados.get(0).funcionado();
        cochesRecuperados.get(1).funcionado();

    }
}
