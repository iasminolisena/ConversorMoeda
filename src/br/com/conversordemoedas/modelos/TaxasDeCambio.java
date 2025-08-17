package br.com.conversordemoedas.modelos;
import com.google.gson.JsonObject;

public class TaxasDeCambio {
    private String moedaOrigem;
    private String moedaDestino;
    private double taxa;
    private String dataAtualizacao;

    public TaxasDeCambio(JsonObject json, String moedaDestino) {
        this.moedaOrigem = json.get("base_code").getAsString();
        this.moedaDestino = moedaDestino;
        this.taxa = json.getAsJsonObject("conversion_rates").get(moedaDestino).getAsDouble();
        this.dataAtualizacao = json.get("time_last_update_utc").getAsString();
    }

    public double getTaxa() {
        return taxa;
    }

    @Override
    public String toString() {
        return "O valor da moeda " + moedaOrigem + " para " + moedaDestino + " é de: " + taxa +
                "\nÚltima atualização: " + dataAtualizacao + "\n";
    }

}
