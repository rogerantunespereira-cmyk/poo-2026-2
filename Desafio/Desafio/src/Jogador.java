/*
 * | DESAFIO 11.11: MERCADO DE TROCAS
 *
 * HISTORIA: Ana tem 5 cristais. Leo tem 0.
 * Ana quer enviar 2 para Leo; ao final, Ana tera 3, Leo tera 2.
 * Se Ana tentar enviar 999, nada pode mudar no estoque de nenhum deles.
 *
 * MISSOES NA ORDEM:
 * [1] receber(): validar, guardar quantidade no Map, marcar item no Set,
 *     registrar evento na List.
 * [2] quantidadeDe(): item ausente precisa retornar zero.
 * [3] tiposJaDescobertos(): devolver o total de nomes unicos.
 * [4] transferirPara(): checar argumentos, impedir autotransferencia,
 *     exigir saldo, modificar os DOIS jogadores so em caso de sucesso.
 * [5] getMovimentacoes(): proteger o historico retornando copia.
 *
 * REGRAS: quantidade <= 0 e destino null: IllegalArgumentException.
 * Quantidade maior que estoque ou destino igual a origem: return false.
 * BÔNUS: remover a chave do Map quando o estoque chegar a zero.
 *
 * COMO SABER SE RESOLVI?
 * Compile e execute TesteDesafio.java. Meta: 9/9 cenarios passando.
 * ATENCAO: nao altere os testes para simular sucesso.
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MISSÃO: Mercado de trocas! Implemente os TODOs sem consultar o gabarito.
 * Dica: use List para histórico, Set para descoberta e Map para estoque.
 */
public class Jogador {
    private final String nome;
    private final Map<String, Integer> estoque = new HashMap<>();
    private final Set<String> itensJaDescobertos = new HashSet<>();
    private final List<String> movimentacoes = new ArrayList<>();

    public Jogador(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do jogador é obrigatório.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Recebe itens. Deve somar quantidades, registrar descoberta e histórico.
     * Nome em branco ou quantidade <= 0 deve gerar IllegalArgumentException.
     */
    public void receber(String item, int quantidade) {
        // TODO 1: validar argumentos, alterar Map, Set e List.
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("Nome do item é obrigatório.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        estoque.put(item, estoque.getOrDefault(item, 0) + quantidade);
        itensJaDescobertos.add(item);
        movimentacoes.add("Recebeu " + quantidade + " de " + item);
    }

    /** Retorna o estoque atual; item desconhecido deve retornar zero. */
    public int quantidadeDe(String item) {
        // TODO 2: consultar o Map com getOrDefault.
        return estoque.getOrDefault(item, 0);
    }

    /** Quantos nomes diferentes ja passaram pela colecao deste jogador? */
    public int tiposJaDescobertos() {
        // TODO 3: consultar o Set.
        return itensJaDescobertos.size();
    }

    /**
     * Transfere itens para outro jogador SOMENTE se tiver saldo suficiente.
     * Retorna true se transferiu e false se nao havia saldo ou se destino == this.
     * Quantidade <= 0 ou destino null: lance IllegalArgumentException.
     * Transferencia recusada NAO deve alterar nenhum estoque.
     * Transferencia aprovada deve registrar movimento na origem e destino.
     */
    public boolean transferirPara(Jogador destino, String item, int quantidade) {

    if (destino == null) {
        throw new IllegalArgumentException("Destino não pode ser nulo.");
    }

    if (quantidade <= 0) {
        throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
    }

    if (destino == this) {
        return false;
    }

    if (quantidade > quantidadeDe(item)) {
        return false;
    }

    // Remove a quantidade do estoque de origem
    int saldoRestante = quantidadeDe(item) - quantidade;

    if (saldoRestante == 0) {
        estoque.remove(item);
    } else {
        estoque.put(item, saldoRestante);
    }

    // Adiciona o item ao destino.
    // O método receber() também registra o histórico do destino.
    destino.receber(item, quantidade);

    // Registra a saída no histórico da origem.
    movimentacoes.add(
        "Transferiu " + quantidade + " de " + item + " para " + destino.nome
    );

    return true;
}

    public List<String> getMovimentacoes() {
        // TODO 5: retornar COPIA do histórico para proteger encapsulamento.
        return new ArrayList<>(movimentacoes);
    }
}
