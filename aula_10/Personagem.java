package aula_10;

public class Personagem extends Atacante {
    public Personagem(String nome, int energia) {
        super(nome, energia);
    }

    @Override
    public void atacar() throws SemEnergiaException {
        consumirEnergia(1);
        System.out.println(getNome() + " atacou! Energia restante: " + getEnergia());
    }
}
