package ifsc.poo.biblioteca;

public class Emprestimos {
    private Leitores leitor;
    private Livro livro;
    private String data;

    public Emprestimos(Leitores leitor, Livro livro, String data) {
        if (leitor == null || livro == null || data == null){
            System.out.println("Leitor/livro não encontrado");
            return;
        }
        this.leitor = leitor;
        this.livro = livro;
        this.data = data;
    }

    public Leitores getLeitor() { return leitor; }
    public Livro getLivro() { return livro; }
    public String getData() { return data; }
}
