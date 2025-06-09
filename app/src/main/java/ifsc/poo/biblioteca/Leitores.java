package ifsc.poo.biblioteca;

import ifsc.poo.login.Usuario;

public class Leitores implements Comparable<Leitores> {
    private static int contador = 1;
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Leitores(String nome, String endereco, String telefone, Integer id){
        if(nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || id == null){
            System.out.println("Preencha todos os campos!");
            return;
        }
        this.id = contador++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean equals(Object o){
        if( !(o instanceof Leitores l)) return false;
        return l.getId().equals(this.id);
    }

    public int compareTo(Leitores outro) {
        return this.nome.compareToIgnoreCase(outro.nome); // Ignora maiúsculas/minúsculas
    }
}
