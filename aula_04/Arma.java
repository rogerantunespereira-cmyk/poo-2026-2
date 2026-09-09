public class Arma {

    private String nome;
    private int dano;

    public Arma(String nome, int dano) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                "O nome da arma não pode ficar vazio"
            );
        }

        if (dano < 0) {
            throw new IllegalArgumentException(
                "O dano não pode ser negativo"
            );
        }

        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }
}
