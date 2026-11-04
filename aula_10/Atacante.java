package aula_10;

public abstract class Atacante {
    private final String nome;
    private int energia;

    protected Atacante(String nome, int energia) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do atacante não pode ser nulo ou vazio.");
        }
        if (energia < 0) {
            throw new IllegalArgumentException("A energia do atacante não pode ser negativa.");
        }

        this.nome = nome;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    protected void consumirEnergia(int custo) throws SemEnergiaException {
        if (custo < 0) {
            throw new IllegalArgumentException("O custo de energia não pode ser negativo.");
        }
        if (energia < custo) {
            throw new SemEnergiaException(nome + " não tem energia suficiente para atacar.");
        }
        energia -= custo;
    }

    public abstract void atacar() throws SemEnergiaException;
}