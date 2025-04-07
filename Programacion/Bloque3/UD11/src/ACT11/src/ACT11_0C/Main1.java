package ACT11_0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main1 {

    public static void main(String[] args) {
        // API key provided by NASA (optional but recommended)
        String apiKey = "L7R8Q5MKhuHT175eCnKItEDLTvjwCdUVF3y6YavQ";

        // URL for the Astronomy Picture of the Day (APOD) endpoint
        String adrecaURL = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

        try {
            // Create a URL object
            URL url = new URL(adrecaURL);

            // Open a conexio to the URL
            HttpURLConnection conexio = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            conexio.setRequestMethod("GET");

            // Get the input stream from the conexio
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexio.getInputStream()))) {
                // Read the response line by line
                String line;
                StringBuilder arxiu = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    arxiu.append(line);
                }
                // Print the response
                System.out.println(arxiu.toString());
            }

            // Connection will be automatically closed at the end of the try-with-resources block
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
