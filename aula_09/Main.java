package aula_09;

public class Main {

    public static void tentar(int energia) {
        try {
            if ( energia == 0 ) {
                throw new IllegalArgumentException(" Não pode atacar sem energia");
            }
        } catch ( IllegalArgumentException erro) {
            System.out.println("Ataque recusado: " + erro.getMessage());
        } finally {
            System.out.println("Fim da tentativa.");
        }
       
    }

    public static void main(String[] args) {
        tentar(0);
        tentar(3);
        System.out.println("Fim.");

    }
}
