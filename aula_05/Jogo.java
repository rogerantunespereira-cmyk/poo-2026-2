package aula_05;

public class Jogo {
    private String nome;
    private String plataforma;
    private String classificacao;

    public Jogo(String nome, String plataforma, String classificacao) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.classificacao = classificacao;
    }

    public void exibirStatus() {
    System.out.println("\n=====GAME_STATUS=====");
    System.out.println("Título de jogo: " + nome);
    System.out.println("Plataforma jogável: " + plataforma);
    System.out.println("Classificação indicativa: " + classificacao);

}
}
