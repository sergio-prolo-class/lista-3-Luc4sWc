package ifsc.poo.biblioteca;

public class Autor implements Comparable<Autor> {
    private String nome;
    private String idioma;

    public Autor(String nome, String idioma) {
        this.nome = nome;
        this.idioma = idioma;
    }

    public String getNome() { return nome; }
    public String getIdioma() { return idioma; }

    public int compareTo(Autor outro) {
        return this.getNome().compareTo(outro.getNome());
    }
}
