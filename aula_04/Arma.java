public class Arma {

    private String nome;
    private int dano;
    
    public Arma(String nome, int dano) {
        if ( nome == null) {
            throw new IllegalArgumentException("O nome da ama não pode ficar vazio");
        }

        if ( dano < 0) {
            throw new IllegalArgumentException("O dano não é válido como um dano real");
        }
        
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }
    
}
