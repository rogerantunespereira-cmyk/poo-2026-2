public class Armadura {
    
    private String nome;
    private int defesa;

    public Armadura(String nome, int defesa) {
        this.nome = nome;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getDefesa() {
       return defesa;
    }
}
