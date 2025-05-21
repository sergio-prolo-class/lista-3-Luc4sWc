package ifsc.poo.atendimento;

public class Solicitacao {
    private final Cliente cliente;
    private final String descricao;
    private final String categoria;

    public Solicitacao(Cliente cliente, String descricao, String categoria) {
        if (cliente == null) {
            assert cliente != null;
        }
        this.cliente = cliente;

        if (descricao == null || descricao.trim().isEmpty()) {
            this.descricao = "Sem descrição";
        } else {
            this.descricao = descricao;
        }

        if (!categoria.equals("Informação") || !categoria.equals("Suporte Técnico") || !categoria.equals("Atendimento Financeiro")) {
            assert cliente != null;
        }
        this.categoria = categoria;
    }

    public Cliente getCliente() { return cliente; }

    public String getDescricao() { return descricao; }

    public String getCategoria() { return categoria; }
}
