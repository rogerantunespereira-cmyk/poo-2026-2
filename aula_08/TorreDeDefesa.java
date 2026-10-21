package aula_08;

public class TorreDeDefesa implements Atacante {
    private final String local;

    public TorreDeDefesa(String local) {
        this.local = local;
    }

    public void atacar() {
        System.out.println("Torre " + local + " Disparou!");
    }
    
}
