public class Armadura {

    private String nome;
    private int defesa;

    public Armadura(String nome, int defesa) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                "O nome da armadura não pode ficar vazio."
            );
        }

        if (defesa < 0) {
            throw new IllegalArgumentException(
                "A defesa não pode ser negativa."
            );
        }

        this.nome = nome;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getDefesa() {
        return defesa;
    }
}
