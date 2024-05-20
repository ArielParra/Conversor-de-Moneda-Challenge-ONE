import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    public void conversionMoneda(String monedaIN, String monedaOUT, float magnitud){
        String direccion = "https://v6.exchangerate-api.com/v6/97df023b1493ae26d6bc382f/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        try {
            HttpResponse<String> response = client .send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            if (!jsonResponse.get("result").getAsString().equals("success")) {
                throw new RuntimeException("Error en la respuesta de la API: " + jsonResponse.get("error").getAsString());
            }
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
            float rateIN = conversionRates.get(monedaIN).getAsFloat();
            float rateOUT = conversionRates.get(monedaOUT).getAsFloat();
            float resultado = (magnitud / rateIN) * rateOUT;
            System.out.println(magnitud + " [" + monedaIN + "] equivalen a " + resultado + " [" + monedaOUT + "]");
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la conversión de moneda: " + e.getMessage());
        }
    }
}
