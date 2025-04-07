package ACT11_0C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main2 {

    public static void main(String[] args) {
        // API key proporcionada por NASA (opcional pero recomendada)
        String apiKey = "L7R8Q5MKhuHT175eCnKItEDLTvjwCdUVF3y6YavQ";

        // URL para el punto final de la Imagen Astronómica del Día (APOD)
        String urlAddress = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

        try {
            // Crear un objeto URL
            URL url = new URL(urlAddress);

            // Abrir una conexión a la URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Establecer el método de solicitud a GET
            connection.setRequestMethod("GET");

            // Obtener el flujo de entrada desde la conexión
            try ( BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                  BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\winadmin\\APIResponse.txt")) ) {

                // Leer la respuesta línea por línea y escribir en el archivo
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine(); // A?adir un salto de línea después de cada línea
                }
                // Confirmar que se ha escrito la respuesta en el archivo
                System.out.println("La respuesta de la API se ha guardado en el archivo 'APIResponse.txt'");
            }
            // Connection will be automatically closed at the end of the try-with-resources block
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
