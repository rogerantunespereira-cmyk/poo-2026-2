package aula_10;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome, int energia) {
        super(nome, energia);
    }

    @Override
    public void atacar() throws SemEnergiaException {
        consumirEnergia(2);
        System.out.println("Guerreiro " + getNome() + " atacou com espada! Energia restante: " + getEnergia());
    }
}
