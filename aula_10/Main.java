package aula_10;

public class Main {
    public static void main(String[] args) {
        Atacante[] equipe = {
            new Arqueiro("Arqueiro Verde", 5),
            new Guerreiro("Rei Arthur", 10),
            new TorreDeDefesa("Torre A")
        };

        for (int rodada = 1; rodada <= 3; rodada++) {
            System.out.println("\n === RODADA " + rodada + " ===");
            for (Atacante atacante : equipe) {
                try {
                    atacante.atacar();
                } catch (SemEnergiaException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println();
        }
    }
}