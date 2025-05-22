package ifsc.poo.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private Integer isbn;
    private List<Autor> autores = new ArrayList<>();

    public Livro(String titulo, Integer isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public Integer getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public List<Autor> getAutores() { return autores; }
}
