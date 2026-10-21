package aula_08;

public class Guerreiro extends Personagem {
     public Guerreiro(String Nome) {
        super(Nome);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " Atacou com a Espada!");
    }
}

