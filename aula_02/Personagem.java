public class Personagem {

        String nome;
        int nível;
        int vida;
        int força;
        int critico;
       

    void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nível);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + força);
    }
        
        
    void atacar(Personagem oponente) {
        System.out.println(nome + " Atacou " + oponente.nome);
        System.out.println("O dano do ataque foi: " + força);
        oponente.vida = oponente.vida - força;
        System.out.println("Ficando com apenas " + oponente.vida + " Pontos de vida");
   }

    void defender(Personagem oponente) {

        System.out.println("O " + oponente.nome + " atacou " + nome);
        vida = vida - oponente.força;
        System.out.println("O ataque causou " + oponente.força + " e a vida de " + nome + " ficou: " + vida + " Pontos de vida");
   }


   void critar(Personagem oponente) {
        System.out.println(nome + " Atacou com muita precisão o " + oponente.nome);
        System.out.println("O dano do ataque foi: " + critico);
        oponente.vida = oponente.vida - critico;
        System.out.println("Ficando com apenas " + oponente.vida + " Pontos de vida");
   }


   void checklife() {
     if (vida <= 0) {
        System.out.println(nome + " Está Morto.");
     } else{
        System.out.println(nome + " Continua a Batalha");
     }
   }


   }
