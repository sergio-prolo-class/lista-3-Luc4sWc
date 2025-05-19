package ifsc.poo.atendimento;

import ifsc.poo.login.Usuario;

public class Cliente {
    private String nome;
    private String telefone;

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.trim().isEmpty()) {
            this.telefone = telefone;
        }
        System.out.println("Telefone Inválido");
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean equals(Object o){
        if( !(o instanceof Cliente u)) return false;
        return u.getTelefone().equals(this.telefone);
    }

    public int hashCode(){
        return this.telefone.hashCode();
    }

    public Cliente(String nome, String telefone){
        if(nome == null) {
            System.out.println("Nome Inválido");
            nome = "cliente";
        }
        if(telefone == null){
            System.out.println("Telefone Inválido");
            telefone = "(00) 00000-0000";
        }

        this.nome = nome;
        this.telefone = telefone;
    }
}
