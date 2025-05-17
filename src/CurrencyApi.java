import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApi {
    String apiKey = "3ed15e384a70fe97d6c7d170";

    public Monedas convertirMoneda(String monedaInicial, String monedaFinal){
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaInicial + "/" + monedaFinal;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de conversión.");
        }
    }
}
