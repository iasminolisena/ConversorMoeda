package br.com.conversordemoedas.modelos;
import br.com.conversordemoedas.servicos.BuscadorDeTaxas;
import com.google.gson.JsonObject;
import java.util.Scanner;

public class ConversorMoeda {

    public static void converter(String origem, String destino, String simboloOrigem, String simboloDestino, Scanner scanner, BuscadorDeTaxas buscador) {
        JsonObject json = buscador.buscarTaxaJson(origem);

        if (json != null) {
            System.out.printf("***Converter "+ origem +" para "+ destino + "***\nDigite um valor: ");
            double valor = scanner.nextDouble();

            TaxasDeCambio cambio = new TaxasDeCambio(json, destino);
            double valorConvertido = valor * cambio.getTaxa();

            System.out.printf("\n"+ simboloOrigem + " " + valor + " convertido equivale a " + simboloDestino + " " + valorConvertido + "\n");
            System.out.println(cambio);
        } else {
            System.out.println("Erro ao obter a taxa.");
        }
    }
}
