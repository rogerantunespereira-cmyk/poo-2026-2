public class Personagem {

    private String nome;
    private int vida;
    private int vidaMaxima;
    private int forca;
    private int nivel;

    private Arma arma;

    private Armadura armadura;

    Personagem ( String nome, int vida, int vidaMaxima, int forca, int nivel) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.forca = forca;
        this.nivel = nivel;
    }

    void exibirStatus() {
        System.out.println("\n======STATUS======");
        System.out.println("Nome: " + nome);
        System.out.println("Vida atual: " + vida);
        System.out.println("Vida Máxima: " + vidaMaxima);
        System.out.println("Força: " + forca);
        System.out.println("Nível: " + nivel);
    }

     public String getNome() {
        return nome;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void equiparArma(Arma novaArma) {
        if ( novaArma == null) {
            System.out.println(nome + " tentou equipar uma arma que não existe");
        }
        
        arma = novaArma;
         System.out.println(nome + " Equipou " + arma.getNome() + ".");
    }

    public void equiparArmadura(Armadura novaArmadura) {
        armadura = novaArmadura; 
         System.out.println(nome + " Equipou " + armadura.getNome() + ".");
    }

    public void atacar(Personagem alvo) {
        if ( alvo == null){
            System.out.println(nome + " tentou atacar alguém que não existe");
            return;
        }
        int danoTotal = forca;

        if (arma != null) {
            danoTotal = forca + arma.getDano();
        }
        
        System.out.println( nome + " Atacou " + alvo.getNome());
        alvo.receberDano(danoTotal);
    }

    private void receberDano (int danoTotal) {
        vida -= danoTotal;
        System.out.println(nome + " recebeu o dano e ficou com " + vida);
        
        if (vida < 0) {
            vida = 0;
        }

        if (!estaVivo()) {
            System.out.println(nome + "Foi derrotado." );
            return;
        }
    }

    public void curar( int quantidade) {
        if (!estaVivo()) {
            System.out.println( nome + " esta derrotado, e não pode se curar");
            return;
        }

        int vidaAntes = vida;
        vida += quantidade;

        if ( vida > vidaMaxima) {
            vida = vidaMaxima;
        }

        int curaReal = vida - vidaAntes;

        System.out.println(nome + " curou " + curaReal);
    }

    
}
