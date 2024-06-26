```markdown
# Conversor de Moedas

Este é um projeto simples de conversor de moedas em Java que utiliza a API ExchangeRate-API para obter as taxas de câmbio mais recentes. O usuário pode converter valores entre diferentes moedas e visualizar o histórico das últimas conversões realizadas.

## Funcionalidades

- Conversão de valores entre diferentes moedas.
- Histórico de conversões realizadas.
- Interação com o usuário por meio de um menu no console.

## Moedas Disponíveis para Conversão

- USD - Dólar americano
- ARS - Peso argentino
- BOB - Boliviano boliviano
- BRL - Real brasileiro
- CLP - Peso chileno
- COP - Peso colombiano
- EUR - Euro
- MXN - Peso mexicano
- CNY - Yuan Chinês

## Como Utilizar

1. **Clone o repositório:**

```sh
git clone https://github.com/seuusuario/conversor-de-moedas.git
```

2. **Compile o projeto:**

```sh
cd conversor-de-moedas
javac *.java
```

3. **Execute a aplicação:**

```sh
java AplicacaoConversorMoedas
```

4. **Siga as instruções no console:**
    - Escolha a moeda de origem.
    - Escolha a moeda de destino.
    - Digite o valor a ser convertido.

## Exemplo de Uso

```plaintext
Moedas disponíveis para conversão:
1. USD - Dólar americano
2. ARS - Peso argentino
3. BOB - Boliviano boliviano
4. BRL - Real brasileiro
5. CLP - Peso chileno
6. COP - Peso colombiano
7. EUR - Euro
8. MXN - Peso mexicano
9. CNY - Yuan Chinês

Digite o número da moeda de origem: 4
Digite o número da moeda de destino: 1
Digite o valor em BRL: 560
Valor convertido: 112.00 USD

Deseja realizar outra conversão? (s/n): n

Histórico de Conversões:
560.00 BRL = 112.00 USD
```

## Dependências

Este projeto utiliza a biblioteca [Gson](https://github.com/google/gson) para manipulação de dados JSON. Certifique-se de adicionar o JAR do Gson ao seu projeto ou incluí-lo como dependência no seu build system.

## Estrutura do Projeto

- `ConversorMoedas.java`: Classe principal que realiza a conversão de moedas utilizando a API ExchangeRate-API.
- `HistoricoConversoes.java`: Classe responsável por gerenciar o histórico de conversões.
- `AplicacaoConversorMoedas.java`: Classe que contém o método `main` e interage com o usuário por meio do console.

## API Utilizada

- [ExchangeRate-API](https://www.exchangerate-api.com/) - API de taxas de câmbio.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autor

- Oliveira de O. Junior (https://github.com/Ooliverira/ConversorDeMoeda)

```
