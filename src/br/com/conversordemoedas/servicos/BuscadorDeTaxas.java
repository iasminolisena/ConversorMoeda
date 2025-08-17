package br.com.conversordemoedas.servicos;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

public class BuscadorDeTaxas {

    private final Gson gson = new Gson();
    private final ApiCliente apiCliente = new ApiCliente();

    public JsonObject buscarTaxaJson(String moedaOrigem) {
        String apiKey = System.getenv("API_KEY");

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem.toUpperCase();

        try {
            String respostaJson = apiCliente.get(url);
            return JsonParser.parseString(respostaJson).getAsJsonObject();

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de conexão ou interrupção: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        return null;
    }
}