import java.util.ArrayList;
import java.util.List;

public class HistoricoConversoes {
    private final List<String> historicoConversoes;

    public HistoricoConversoes(){
        this.historicoConversoes = new ArrayList<>();
    }

    public void adicionarConversao(String conversao){
        historicoConversoes.add(conversao);
    }

    public List<String> getHistoricoConversoes() {
        return historicoConversoes;
    }

    public void exibirHistoricoConversoes() {
        if (historicoConversoes.isEmpty()) {
            System.out.println("Nenhuma conversão realizado até o momento.");
        } else {
            for (String entrada : historicoConversoes) {
                System.out.println(entrada);
            }
        }
    }
}
