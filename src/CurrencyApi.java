import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class CurrencyApi {
    private static final String API_KEY = "3ed15e384a70fe97d6c7d170";

    public Conversion convertirMoneda(String monedaInicial, String monedaFinal) {
        String direccion = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaInicial + "/" + monedaFinal;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de conversión.");
        }
    }
}

