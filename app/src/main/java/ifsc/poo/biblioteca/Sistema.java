package ifsc.poo.biblioteca;

import java.util.*;

public class Sistema {
    private Map<Integer, Livro> livros = new HashMap<>();
    private Map<Integer, Leitores> leitores = new HashMap<>();
    private Set<Autor> autores = new LinkedHashSet<>();
    private List<Emprestimos> Emprestimoss = new ArrayList<>();
    private Integer geradorDeId = 1;
    private Map<Integer,Integer> copiasDisponiveis = new HashMap();

    public void cadastrarLeitor(String nome, String endereco, String telefone) {
        Leitores leitor = new Leitores(nome, endereco, telefone, geradorDeId);
        leitores.put(leitor.getId(), leitor);
        geradorDeId++;//id sempre único
    }

    public void cadastrarLivro(String titulo, Integer isbn, int copias, Set<Autor> autoresLivro) {
        Livro livro = new Livro(titulo, isbn);
        for (Autor autor : autoresLivro){
            livro.adicionarAutor(autor);
            autores.add(autor);
        }
        livros.put(isbn, livro);
        copiasDisponiveis.put(isbn, copias);
    }

    private boolean temCopiaDisponivel(Integer isbn) {
        return copiasDisponiveis.containsKey(isbn) && copiasDisponiveis.get(isbn) > 0;
    }

    private void emprestar(Integer isbn) {
        if (temCopiaDisponivel(isbn)){
            copiasDisponiveis.put(isbn, copiasDisponiveis.get(isbn) - 1);
            return;
        }
        System.out.println("Livro não esta disponivel");
    }


    public void registrarEmprestimos(int leitorId, Integer isbn,String data) {
        Leitores leitor = leitores.get(leitorId);
        Livro livro = livros.get(isbn);

        if (leitor == null || livro == null || !temCopiaDisponivel(isbn)){
            System.out.println("Leitor/livro não encontrado ou Livro Indisponivel");
            return;
        }

        long EmprestimossAtuais = Emprestimoss.stream()
                .filter(e -> e.getLeitor().getId() == leitorId)
                .count();

        if (EmprestimossAtuais >= 5){
            System.out.println("Você passou do limite de Emprestimos");
            return;
        }

        emprestar(isbn);
        Emprestimoss.add(new Emprestimos(leitor, livro, data));
    }

    public void listarEmprestimosPorData() {
        Emprestimoss.stream()
                .sorted(Comparator.comparing(Emprestimos::getData))
                .forEach(e -> System.out.println(e.getLivro().getTitulo() + " - " + e.getData()));
    }

    void listarAutores() {
        // ordena com base no compareTo
        for (Autor a : autores) {// agora dá certo
            System.out.println(a.getNome());  // usa o toString()
        }
    }

    void listarLeitores() {
        List<Leitores> listaLeitores = new ArrayList<>(leitores.values());

        listaLeitores.sort(Comparator.comparing(Leitores::getNome, String.CASE_INSENSITIVE_ORDER));

        for (Leitores l : listaLeitores) {
            System.out.println("Nome: " + l.getNome());
        }
    }

    void listarLeitoresID(){
        leitores.values().forEach(e -> System.out.println("ID: " + e.getId()));
    }

    public void listarEmprestimosDeLeitor(Integer idLeitor) {
        List<Emprestimos> EmprestimossDoLeitor = new ArrayList<>();

        for (Emprestimos e : Emprestimoss) {
            if (e.getLeitor().getId().equals(idLeitor)) {
                EmprestimossDoLeitor.add(e);
            }
        }

        EmprestimossDoLeitor.sort(Comparator.comparing(Emprestimos::getData));

        for (Emprestimos e : EmprestimossDoLeitor) {
            System.out.println("Livro: " + e.getLivro().getTitulo() + " | Data: " + e.getData());
        }
    }

    void listarLivrosID(){
        livros.values().forEach(e -> System.out.println("ID: " + e.getIsbn()));
    }

    void listarTitulos(){
        livros.values().forEach(e -> System.out.println(e.getTitulo()));
    }

    void listarLivrosPorAutor(){
        // Agrupa os livros por autor (assumindo que getAutores() retorna List<Autor>)
        Map<String, List<Livro>> livrosPorAutor = new HashMap<>();

        for (Livro livro : livros.values()) {
            for (Autor autor : livro.getAutores()) { // Alteração aqui: String -> Autor
                String nomeAutor = autor.getNome(); // Supondo que Autor tem um método getNome()
                livrosPorAutor.computeIfAbsent(nomeAutor, k -> new ArrayList<>()).add(livro);
            }
        }

        // Imprime os livros agrupados por autor
        livrosPorAutor.forEach((nomeAutor, lista) -> {
            System.out.println("Autor: " + nomeAutor);
            lista.forEach(l -> System.out.println("  - " + l.getTitulo()));
        });
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        Autor Tolkien = new Autor("J.R.R Tolkien", "Inglês");
        Autor Machado = new Autor("Machado de Assis", "Português BR");
        Autor Clarice = new Autor("Clarice Lispector", "Português BR");


        sistema.cadastrarLeitor("Carambolas","Caxumbeiras","555-517-266");
        sistema.cadastrarLeitor("Pinpolho","Pindamonhagaba","445-556-752");
        sistema.cadastrarLeitor("Fulana","TaquiPariu","252-522-873");
        sistema.cadastrarLeitor("Rogério","Paraisopoles","422-643-541");
        sistema.cadastrarLeitor("Joana","CasaDaMãeJoana","242-455-625");

        sistema.cadastrarLivro("Senhor Dos Anals", 111111,9, Set.of(Tolkien,Machado));
        sistema.cadastrarLivro("Dom Cascudo", 222222,4, Set.of(Machado));
        sistema.cadastrarLivro("A Hora da Estrela", 321654, 1, Set.of(Clarice));

        sistema.registrarEmprestimos(1,111111,"20/02/2025");
        sistema.registrarEmprestimos(1,111111,"20/02/2025");
        sistema.registrarEmprestimos(1,111111,"20/02/2025");
        sistema.registrarEmprestimos(1,111111,"20/02/2025");
        sistema.registrarEmprestimos(1,111111,"20/02/2025");
        sistema.registrarEmprestimos(1,111111,"20/02/2025");

        System.out.println("-----------------------------------------------------------------------------");

        sistema.registrarEmprestimos(2,321654,"09/06/2025");
        sistema.registrarEmprestimos(3,321654,"10/06/2025");

        System.out.println("-----------------------------------------------------------------------------");

        sistema.registrarEmprestimos(3,222222,"10/06/2025");
        sistema.registrarEmprestimos(4,222222,"31/09/2025");
        sistema.registrarEmprestimos(5,222222,"20/10/2025");

        sistema.cadastrarLivro("A Hora da Estrela", 321654, 1, Set.of(Clarice));

        sistema.registrarEmprestimos(5,321654,"05/11/2025");
        sistema.registrarEmprestimos(6,111111,"25/11/2025");

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarLivrosID();

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarTitulos();

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarLivrosPorAutor();

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarAutores();

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarLeitores();

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarLeitoresID();

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarEmprestimosDeLeitor(4);

        System.out.println("-----------------------------------------------------------------------------");

        sistema.listarEmprestimosPorData();


    }

}
