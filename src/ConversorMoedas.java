import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoedas {
    private static final String API_KEY = "79a780d50ce245ea1023792e";
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    private HistoricoConversoes historico;


        public ConversorMoedas(HistoricoConversoes historico){
        this.historico = historico;
    }

    private double buscarTaxasDeCambio(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String url = URL_API + moedaOrigem;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200){
            throw new RuntimeException("Erro ao acessar a API.");
        }

        String responseBody = response.body();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        return conversionRates.get(moedaDestino).getAsDouble();
    }

    public double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {
      try {
          double taxaCambio = buscarTaxasDeCambio(moedaOrigem, moedaDestino);
          double valorConvertido = valor * taxaCambio;
          String entradahistorico = String.format("%.2f %s = %.2f %s", valor, moedaOrigem, valorConvertido, moedaDestino);
          historico.adicionarConversao(entradahistorico);
          return valorConvertido;
      } catch (IOException | InterruptedException e) {
          throw new RuntimeException("Erro ao buscar taxa de câmbio: " + e.getMessage());

      }
    }
}
