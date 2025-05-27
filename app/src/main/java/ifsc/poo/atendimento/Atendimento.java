package ifsc.poo.atendimento;

import com.google.common.cache.RemovalListener;
import ifsc.poo.login.Usuario;

import java.util.*;
import java.util.stream.Stream;

public class Atendimento {
    private static final ArrayDeque<Solicitacao> fila = new ArrayDeque<>();
    private static final List<Solicitacao> atendidos = new ArrayList<>();
    private final Map<String, Cliente> clientes = new HashMap<>();

    public void registrarSolicitacao(String nome, String telefone, String descricao, String categoria) {
        Cliente cliente = clientes.computeIfAbsent(telefone, t -> new Cliente(nome, telefone));
        Solicitacao solicitacao = new Solicitacao(cliente, descricao, categoria);
        fila.add(solicitacao);
    }

    public void listarTelefonesClientes() {
        clientes.values().forEach(c -> System.out.println(c.getTelefone()));
    }

    public void imprimeProximoCliente() {
        if (!fila.isEmpty()) {
            Cliente c = fila.getFirst().getCliente();
            System.out.println("Próximo: " + c.getNome());
        }
    }

    public void atenderProximoCliente() {
        if (!fila.isEmpty()) {
            atendidos.add(fila.remove());
        }
    }

    public void listarClientesAtendidos() {
        atendidos.forEach(s -> {
            Cliente c = s.getCliente();
            System.out.println(c.getNome());
        });
    }

    public void listarTelefonesEmEspera() {
        fila.forEach(s -> System.out.println(s.getCliente().getTelefone()));
    }

    public void gerarRelatorio() {
        int total = fila.size() + atendidos.size();
        int emEspera = fila.size();
        int atendidasQtd = atendidos.size();

        Map<String, Integer> categorias = new HashMap<>();
        Stream.concat(fila.stream(), atendidos.stream())
                .forEach(s -> categorias.put(s.getCategoria(), categorias.getOrDefault(s.getCategoria(), 0) + 1));

        System.out.println("Total de solicitações: " + total);
        System.out.println("Atendidas: " + atendidasQtd);
        System.out.println("Em espera: " + emEspera);
        System.out.println("Distribuição por categoria:");
        categorias.forEach((cat, count) -> {
            double perc = 100.0 * count / total;
            System.out.printf("- %s: %.2f%%\n", cat, perc);
        });
    }

    public static void main(String[] args) {
        Atendimento atendimento = new Atendimento();

        atendimento.registrarSolicitacao("Escambal","456-123-789","Tô com probema que não consigo colocar na rick Tv recor","Suporte Técnico");
        atendimento.registrarSolicitacao("Zanildo","555-445-655","Não consigo sacar meu fgts","Atendimento Financeiro");
        atendimento.registrarSolicitacao("Jacundes","523-513-987","Onde fica o banheiro?","Informação");
        atendimento.registrarSolicitacao("Beltrana","975-153-456","Meu ex-namorado não quer pagar a pensão para o meu bebê reborn","Suporte Técnico");

        atendimento.listarTelefonesClientes();

        System.out.println("________________________________________________________________________________________________________________");

        atendimento.atenderProximoCliente();

        atendimento.listarClientesAtendidos();

        System.out.println("________________________________________________________________________________________________________________");

        atendimento.listarTelefonesEmEspera();

        System.out.println("________________________________________________________________________________________________________________");

        atendimento.imprimeProximoCliente();

        System.out.println("________________________________________________________________________________________________________________");

        atendimento.listarClientesAtendidos();

        System.out.println("________________________________________________________________________________________________________________");

        atendimento.gerarRelatorio();

    }
}
