public class Personagem {

    private String nome;
    private int vida;
    private int vidaMaxima;
    private int forca;
    private int nivel;

    private Arma arma;
    private Armadura armadura;

    public Personagem(String nome, int vida, int vidaMaxima, int forca, int nivel) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.forca = forca;
        this.nivel = nivel;
    }

    public void exibirStatus() {
        System.out.println("\n====== STATUS ======");
        System.out.println("Nome: " + nome);
        System.out.println("Vida atual: " + vida);
        System.out.println("Vida Máxima: " + vidaMaxima);
        System.out.println("Força: " + forca);
        System.out.println("Nível: " + nivel);

        if (arma != null) {
            System.out.println("Arma: " + arma.getNome());
        } else {
            System.out.println("Arma: Nenhuma");
        }

        if (armadura != null) {
            System.out.println("Armadura: " + armadura.getNome());
            System.out.println("Defesa: " + armadura.getDefesa());
        } else {
            System.out.println("Armadura: Nenhuma");
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void equiparArma(Arma novaArma) {
        if (novaArma == null) {
            System.out.println(nome + " tentou equipar uma arma que não existe");
            return;
        }

        arma = novaArma;
        System.out.println(nome + " equipou " + arma.getNome() + ".");
    }

    public void equiparArmadura(Armadura novaArmadura) {
        if (novaArmadura == null) {
            System.out.println(nome + " tentou equipar uma armadura que não existe");
            return;
        }

        armadura = novaArmadura;
        System.out.println(nome + " equipou " + armadura.getNome() + ".");
    }

    public void atacar(Personagem alvo) {

        if (alvo == null) {
            System.out.println(nome + " tentou atacar alguém que não existe");
            return;
        }

        if (!estaVivo()) {
            System.out.println(nome + " está derrotado e não pode atacar");
            return;
        }

        int danoTotal = forca;

        if (arma != null) {
            danoTotal += arma.getDano();
        }

        System.out.println("\n" + nome + " atacou " + alvo.getNome() + ".");

        alvo.receberDano(danoTotal);
    }

    private void receberDano(int danoTotal) {

        int defesa = 0;

        if (armadura != null) {
            defesa = armadura.getDefesa();
        }

        int danoRecebido = danoTotal - defesa;

        if (danoRecebido < 0) {
            danoRecebido = 0;
        }

        vida -= danoRecebido;

        System.out.println(nome + " recebeu " + danoRecebido + " de dano");

        if (defesa > 0) {
            System.out.println("A armadura reduziu " + Math.min(defesa, danoTotal) + " de dano");
        }

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nome + " ficou com " + vida + " de vida");

        if (!estaVivo()) {
            System.out.println(nome + " foi derrotado");
        }
    }

    public void curar(int quantidade) {

        if (!estaVivo()) {
            System.out.println(nome + " está derrotado e não pode se curar");
            return;
        }

        if (quantidade < 0) {
            System.out.println("A quantidade de cura não pode ser negativa");
            return;
        }

        int vidaAntes = vida;

        vida += quantidade;

        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }

        int curaReal = vida - vidaAntes;

        System.out.println(nome + " curou " + curaReal + " de vida");
    }
}
