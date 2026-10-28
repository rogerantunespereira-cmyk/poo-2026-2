public class Arqueiro extends Personagem {
    public Arqueiro(String Nome) {
        super(Nome);
    }

   @Override 
    public void atacar() {
        System.out.println(getNome() + " Disparou uma Flecha!");
    }
}
