package ifsc.poo.atendimento;

import ifsc.poo.login.Usuario;

public class Cliente {
    String nome;
    String telefone;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public Usuario(String nome, String telefone){
        if(nome.equals(null)) {
            System.out.println("Nome Inválido");
            nome = "cliente";
        }
        if(telefone.equals(null)){
            System.out.println("Telefone Inválido");
            telefone = "(00) 00000-0000";
        }

        this.nome = nome;
        this.telefone = telefone;
    }
}
