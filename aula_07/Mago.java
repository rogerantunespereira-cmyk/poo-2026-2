
public class Mago extends Personagem {
    public Mago(String Nome) {
        super(Nome);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " Lançou um Feitiço!");
    }
}
