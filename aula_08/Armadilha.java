public class Armadilha implements Atacante {
    private final String identificacao;

    public Armadilha(String identificacao) {
        this.identificacao = identificacao;
    }

    @Override
    public void atacar() {
        System.out.println("Armadilha " + identificacao + " Foi ativada!");
    }
}
