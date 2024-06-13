import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoedas {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/79a780d50ce245ea1023792e/latest/USD";
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    private JsonObject taxasDeCambio;

    public ConversorMoedas(){
        buscarTaxasDeCambio();
    }

    private void buscarTaxasDeCambio() {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL_API))
                .build();

        try{
            HttpResponse<String> resposta = httpClient.send(requisicao, HttpResponse
                    .BodyHandlers.ofString());
            JsonObject respostaJson = new Gson().fromJson(resposta.body(), JsonObject.class);
            taxasDeCambio = respostaJson.getAsJsonObject("conversion_rates");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {
        double taxaOrigem = taxasDeCambio.get(moedaOrigem).getAsDouble();
        double taxaDestino = taxasDeCambio.get(moedaDestino).getAsDouble();
        return (valor / taxaOrigem) * taxaDestino;
    }

    public boolean moedaValida(String moeda) {
        return taxasDeCambio.has(moeda);
    }
}
