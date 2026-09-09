package aula_05;

public class Cliente {
    private String nome;
    private String telefone;

    private Jogo jogo;

     Cliente(String nome, String telefone ) {
        this.nome = nome;
        this.telefone = telefone;
     }

public void exibirStatus() {
    System.out.println("\n=====CLIENTE_STATUS=====");
    System.out.println("Nome do cliente: " + nome);
    System.out.println("Telefone de contato: " + telefone);
}

}
