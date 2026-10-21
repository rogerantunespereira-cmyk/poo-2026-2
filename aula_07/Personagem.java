public class Personagem {
    private String Nome;
    
    public Personagem(String Nome) {
        this.Nome = Nome;
    }

    public String getNome() {
        return Nome;
    }

    public void atacar() {
        System.out.println(Nome + " Atacou!");
    }
}