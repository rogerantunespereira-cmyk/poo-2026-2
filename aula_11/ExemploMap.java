package aula_11;
import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        // Implementação do exemplo de Map
        Map<String, Integer> quantidades = new HashMap<>();

        adicionar(quantidades, "Moedas");
        adicionar(quantidades, "Cristais");
        adicionar(quantidades, "Real");

        System.out.println("Moedas: " + quantidades.getOrDefault("Moeda", 0));
        System.out.println("Espadas: " + quantidades.getOrDefault("Espadas", 0));
        
        for (Map.Entry<String, Integer> entrada : quantidades.entrySet()) {
            System.out.println(entrada.getKey() + " : " + entrada.getValue());
        }

    }

    private static void adicionar(Map<String, Integer> mapa, String nome) {
        int quantidadeAtual = mapa.getOrDefault(nome, 0);
        mapa.put(nome, quantidadeAtual + 1);
    }
}
