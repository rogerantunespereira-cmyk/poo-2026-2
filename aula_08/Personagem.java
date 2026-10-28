public abstract class Personagem implements Atacante {
    private final String Nome;
    
    public Personagem(String Nome) {
        this.Nome = Nome;
    }

    public String getNome() {
        return Nome;
    }

    public void apresentar() {
        System.out.println("Eu sou " + Nome + ".");
    }

    public abstract void atacar();

    

}

