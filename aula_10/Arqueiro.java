package aula_10;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome, int energia) {
        super(nome, energia);
    }

    @Override 
    public void atacar() throws SemEnergiaException {
        consumirEnergia(1);
        System.out.println("Arqueiro " + getNome() + " atacou com arco! Energia restante: " + getEnergia());
}

}