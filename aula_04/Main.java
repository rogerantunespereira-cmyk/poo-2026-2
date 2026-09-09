public class Main {
    public static void main(String[] args ) {

        Personagem guerreiro = new Personagem("Roger", 100, 100, 30, 20);
        Personagem troll = new Personagem("Troll da montanha", 120, 120, 25, 10);

        Arma espada = new Arma("Espada Excalibur", 20);

        Armadura capacete = new Armadura("Capacete de Hyndra", 10);

        System.out.println("Antes");
        guerreiro.exibirStatus();
        troll.exibirStatus();

        guerreiro.equiparArma(espada);
        guerreiro.equiparArmadura(capacete);

        guerreiro.atacar(troll);
        troll.curar(999);
        troll.atacar(guerreiro);
        





    }
    
}
