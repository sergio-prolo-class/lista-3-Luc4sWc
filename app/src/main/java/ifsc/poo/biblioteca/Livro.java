package ifsc.poo.biblioteca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Livro {
    private String titulo;
    private Integer isbn;
    private Set<Autor> autores = new HashSet<>();

    public Livro(String titulo, Integer isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public Integer getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public Set<Autor> getAutores() {
        return autores;
    }
}
