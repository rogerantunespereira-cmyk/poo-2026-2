package aula_11;

import java.util.ArrayList;
import java.util.List;

public class ExemploList {

    public static void main(String[] args) {

        List<String> historico = new ArrayList<>();

        historico.add("Moeda");
        historico.add("Cristais");
        historico.add("Real");

        System.out.println("Baús abertos: " + historico.size());
        System.out.println("Primeiro item: " + historico.get(0));

        for ( String item : historico) {
            System.out.println("Encontrou: " + item);

        }

        historico.remove(1); // Cristais
        System.out.println("Depois da remoção: " + historico);
    }
}