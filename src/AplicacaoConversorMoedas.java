import java.util.Scanner;

public class AplicacaoConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas();

        while (true){
            System.out.println("Escolha uma opção:");
            System.out.println("1. Converter de USD para outra moeda");
            System.out.println("2. Converter de outra moedas para USD");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            switch (escolha){
                case 1:
                    converterDeUSD(conversor, scanner);
                    break;
                case 2:
                    converterDeUSD(conversor, scanner);
                    break;
                case 3:
                    System.out.println("Obrigado por usar o Conversor de Moedas.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }

        }
    }
    private static void converterDeUSD(ConversorMoedas conversor, Scanner scanner){
        System.out.println("\nMoedas disponíveis para conversão:");
        System.out.println("ARS - Peso argentino");
        System.out.println("BOB - Boliviano boliviano");
        System.out.println("BRL - Real brasileiro");
        System.out.println("CLP - Peso chileno");
        System.out.println("COP - Peso colombiano");

        System.out.println("\nDigite o codigo da moeda para conversão: ");
        String moedaOrigem = scanner.next();

        if (!conversor.moedaValida(moedaOrigem)) {
            System.out.println("Moeda inválida. Escolha novamente.");
            return;
        }

        System.out.println("Digite o valor em " + moedaOrigem + ": ");
        double valor = scanner.nextDouble();

        double valorConvertido = conversor.converterMoeda(valor, moedaOrigem, "USD");
        System.out.println(valor + " " + moedaOrigem + " equivalem a "
                + valorConvertido + "USD");

    }
}

