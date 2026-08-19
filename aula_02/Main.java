public class Main {
    
    public static void main (String[] args) {

        Personagem guerreiro = new Personagem();

        guerreiro.nome = "Roger";
        guerreiro.vida = 100;
        guerreiro.força = 30;
        guerreiro.nível = 30;
        guerreiro.critico = 60;

        guerreiro.exibirStatus();


        Personagem monstro = new Personagem();

        monstro.nome = "Veneza";
        monstro.vida = 200;
        monstro.força = 20;
        monstro.nível = 50;


        monstro.exibirStatus();


        guerreiro.atacar(monstro);
        guerreiro.defender(monstro);
        guerreiro.checklife();
        monstro.checklife();
        guerreiro.atacar(monstro);
        guerreiro.defender(monstro);
        guerreiro.checklife();
        monstro.checklife();
        guerreiro.critar(monstro);
        guerreiro.defender(monstro);
        guerreiro.checklife();
        monstro.checklife(); 
        guerreiro.atacar(monstro);
        guerreiro.defender(monstro);
        guerreiro.checklife();
        monstro.checklife();
        guerreiro.critar(monstro);
        guerreiro.checklife();
        monstro.checklife();
        

        
    }
    
}
