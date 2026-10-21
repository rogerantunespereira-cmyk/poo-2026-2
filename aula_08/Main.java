package aula_08;

public class Main {
    public static void main(String[] args) {
        


     System.out.println("========");
 
     Atacante[] atacantes = {
        new TorreDeDefesa("Norte"),
        new Arqueiro("Robin"),
        new Armadilha("Espinhos"),
        new Guerreiro("Artur"),
        new Mago("Merlin")
     };

     for (Atacante item : atacantes) {
        item.atacar();
     }


    }
}