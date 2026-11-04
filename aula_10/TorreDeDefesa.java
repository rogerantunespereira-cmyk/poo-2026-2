package aula_10;

public class TorreDeDefesa extends Atacante {
    public TorreDeDefesa(String nome) {
        super(nome, 0);
    }

    @Override
    public void atacar() throws SemEnergiaException {
        System.out.println("Torre de defesa " + getNome() + " está pronta para atacar.");
    }
}
