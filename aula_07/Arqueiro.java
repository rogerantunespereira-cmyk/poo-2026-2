package aula_07;

public class Arqueiro extends Personagem {
    public Arqueiro(String Nome) {
        super(Nome);
    }

   @Override 
    public void atacar() {
        System.out.println(getNome() + " Atirou uma Flecha!");
    }
}