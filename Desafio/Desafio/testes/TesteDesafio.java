import java.util.List;

/** Testes para ajudar a verificar requisitos; nao precisam de JUnit. */
public class TesteDesafio {
    private static int aprovados = 0;

    public static void main(String[] args) {
        executar("receber e consultar", () -> {
            Jogador a = new Jogador("A");
            a.receber("Cristal", 2);
            a.receber("Cristal", 3);
            verificar(a.quantidadeDe("Cristal") == 5, "Deve somar 2 + 3");
            verificar(a.quantidadeDe("Moeda") == 0, "Desconhecido vale zero");
        });
        executar("colecao sem duplicatas", () -> {
            Jogador a = new Jogador("A");
            a.receber("Cristal", 1);
            a.receber("Cristal", 1);
            a.receber("Moeda", 1);
            verificar(a.tiposJaDescobertos() == 2, "Somente dois nomes unicos");
        });
        executar("troca valida", () -> {
            Jogador a = new Jogador("A");
            Jogador b = new Jogador("B");
            a.receber("Moeda", 5);
            verificar(a.transferirPara(b, "Moeda", 3), "Troca deve ocorrer");
            verificar(a.quantidadeDe("Moeda") == 2, "Origem perde 3");
            verificar(b.quantidadeDe("Moeda") == 3, "Destino ganha 3");
            verificar(b.tiposJaDescobertos() == 1, "Destino descobre item");
        });
        executar("troca recusada nao altera dados", () -> {
            Jogador a = new Jogador("A");
            Jogador b = new Jogador("B");
            a.receber("Moeda", 2);
            verificar(!a.transferirPara(b, "Moeda", 3), "Recusa saldo insuficiente");
            verificar(a.quantidadeDe("Moeda") == 2, "Origem mantem saldo");
            verificar(b.quantidadeDe("Moeda") == 0, "Destino continua sem item");
        });
        executar("nao pode negociar consigo", () -> {
            Jogador a = new Jogador("A");
            a.receber("Moeda", 3);
            verificar(!a.transferirPara(a, "Moeda", 2), "Autotroca deve falhar");
            verificar(a.quantidadeDe("Moeda") == 3, "Saldo nao muda");
        });
        executar("quantidade invalida gera erro", () -> {
            Jogador a = new Jogador("A");
            verificar(lancou(() -> a.receber("Moeda", 0)), "Receber zero nao permitido");
            verificar(lancou(() -> a.transferirPara(new Jogador("B"), "Moeda", -1)),
                    "Transferir quantidade negativa nao permitido");
        });
        executar("destino nulo gera erro", () -> {
            Jogador a = new Jogador("A");
            verificar(lancou(() -> a.transferirPara(null, "Moeda", 1)),
                    "Destino nulo deve ser recusado por excecao");
        });
        executar("historico registra ambos os lados", () -> {
            Jogador a = new Jogador("A");
            Jogador b = new Jogador("B");
            a.receber("Moeda", 3);
            a.transferirPara(b, "Moeda", 2);
            verificar(a.getMovimentacoes().size() == 2,
                    "Origem: recebimento e saida");
            verificar(b.getMovimentacoes().size() == 1,
                    "Destino: entrada por troca");
        });
        executar("encapsulamento do historico", () -> {
            Jogador a = new Jogador("A");
            a.receber("Cristal", 1);
            List<String> copia = a.getMovimentacoes();
            copia.clear();
            verificar(a.getMovimentacoes().size() == 1,
                    "Alterar copia nao altera historico real");
        });
        System.out.println("\n" + aprovados + "/9 cenarios aprovados.");
        if (aprovados != 9) {
            throw new AssertionError("A missão ainda tem cenarios pendentes: " + (9 - aprovados));
        }
    }

    private static void executar(String nome, Runnable teste) {
        try {
            teste.run();
            aprovados++;
            System.out.println("PASSOU: " + nome);
        } catch (Throwable erro) {
            System.out.println("FALHOU: " + nome + " -> " + erro.getMessage());
        }
    }

    private static boolean lancou(Runnable tarefa) {
        try {
            tarefa.run();
        } catch (IllegalArgumentException esperado) {
            return true;
        }
        return false;
    }

    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }
}
