import br.com.conversordemoedas.servicos.BuscadorDeTaxas;
import java.util.InputMismatchException;
import java.util.Scanner;
import static br.com.conversordemoedas.modelos.ConversorMoeda.converter;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BuscadorDeTaxas converterMoeda = new BuscadorDeTaxas();
        int selecaoMoedas;

        while (true){
            System.out.println("\nCONVERSOR DE MOEDAS");
            System.out.println("***********************************************");
            System.out.println("Escolha uma opção para realizar a conversão:");
            System.out.println("1 - Dólar para Real");
            System.out.println("2 - Real para Dolar");
            System.out.println("3 - Euro para Real");
            System.out.println("4 - Real para Euro");
            System.out.println("5 - Peso Argentino para Real");
            System.out.println("6 - Real para Peso Argentino");
            System.out.println("7 - Sair");

            try {
                selecaoMoedas = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número de 1 a 7.");
                scanner.close();
                return;
            }

            switch (selecaoMoedas) {
                case 1 -> converter("USD", "BRL", "US$", "R$", scanner, converterMoeda);
                case 2 -> converter("BRL", "USD", "R$", "US$", scanner, converterMoeda);
                case 3 -> converter("EUR", "BRL", "€", "R$", scanner, converterMoeda);
                case 4 -> converter("BRL", "EUR", "R$", "€", scanner, converterMoeda);
                case 5 -> converter("ARS", "BRL", "AR$", "R$", scanner, converterMoeda);
                case 6 -> converter("BRL", "ARS", "R$", "AR$", scanner, converterMoeda);
                case 7 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}


