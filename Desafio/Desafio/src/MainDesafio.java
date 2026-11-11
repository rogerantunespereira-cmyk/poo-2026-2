
public class MainDesafio {
    public static void main(String[] args) {
        Jogador ana = new Jogador("Ana");
        Jogador leo = new Jogador("Léo");

        ana.receber("Cristal", 3);
        ana.receber("Moeda", 10);
        ana.receber("Cristal", 2);

        System.out.println("Ana tem " + ana.quantidadeDe("Cristal") + " cristais (esperado: 5)");
        System.out.println("Ana descobriu " + ana.tiposJaDescobertos() + " tipos (esperado: 2)");

        boolean passou = ana.transferirPara(leo, "Cristal", 2);
        System.out.println("Troca feita? " + passou + " (esperado: true)");
        System.out.println("Ana: " + ana.quantidadeDe("Cristal") + " cristais (esperado: 3)");
        System.out.println("Léo: " + leo.quantidadeDe("Cristal") + " cristais (esperado: 2)");

        boolean recusada = ana.transferirPara(leo, "Cristal", 999);
        System.out.println("Troca impossível aceita? " + recusada + " (esperado: false)");
        System.out.println("Movimentações de Ana: " + ana.getMovimentacoes());
        System.out.println("Movimentações de Léo: " + leo.getMovimentacoes());
    }
}
