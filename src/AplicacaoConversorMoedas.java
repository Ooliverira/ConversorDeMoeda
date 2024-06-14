import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AplicacaoConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoricoConversoes historicoConversoes = new HistoricoConversoes();
        ConversorMoedas conversor = new ConversorMoedas(historicoConversoes);

        while (true){
            System.out.println("Escolha uma opção:");
            System.out.println("1. Converter moedas");
            System.out.println("2. Ver histórico de conversões");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            switch (escolha){
                case 1:
                    converterMoeda(conversor, scanner);
                    break;
                case 2:
                    historicoConversoes.exibirHistoricoConversoes();
                    break;
                case 3:
                    System.out.println("Obrigado por usar o Conversor de Moedas.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }

        }
    }
    private static void converterMoeda(ConversorMoedas conversor, Scanner scanner){
        Map<Integer, String> moedas = new HashMap<>();
        moedas.put(1, "USD");
        moedas.put(2, "ARS");
        moedas.put(3, "BOB");
        moedas.put(4, "BRL");
        moedas.put(5, "CLP");
        moedas.put(6, "COP");
        moedas.put(7, "EUR");
        moedas.put(8, "MXN");
        moedas.put(9, "CNY");

        System.out.println("\n--------------------------\n");
        System.out.println("\nMoedas disponíveis para conversão:");
        System.out.println("1. USD - Dólar americano");
        System.out.println("2. ARS - Peso argentino");
        System.out.println("3. BOB - Boliviano boliviano");
        System.out.println("4. BRL - Real brasileiro");
        System.out.println("5. CLP - Peso chileno");
        System.out.println("6. COP - Peso colombiano");
        System.out.println("7. EUR - Euro");
        System.out.println("8. MXN - Peso mexicano");
        System.out.println("9. CNY - Yuan Chinês");

        System.out.println("\nDigite o codigo da moeda para conversão: ");
        int escolhaOrigem = scanner.nextInt();
        if (!moedas.containsKey(escolhaOrigem)) {
            System.out.println("Moeda inválida. Escolha novamente.");
            return;
        }
        String moedaOrigem = moedas.get(escolhaOrigem);

        System.out.println("Digite o número da moeda de destino: ");
        int escolhaDestino = scanner.nextInt();
        if (!moedas.containsKey(escolhaDestino)) {
            System.out.println("Escolha inválida. Por favor, tente novamente.");
            return;
        }
        String moedaDestino = moedas.get(escolhaDestino);

        System.out.println("Digite o valor em " + moedaOrigem + ": ");
        double valor = scanner.nextDouble();

        double valorConvertido = conversor.converterMoeda(valor, moedaOrigem, moedaDestino);
        System.out.println("\n--------------------------\n");
        System.out.println(valor + " " + moedaOrigem + " equivalem a "
                + valorConvertido + " " + moedaDestino);
        System.out.println("\n--------------------------\n");


    }
}

