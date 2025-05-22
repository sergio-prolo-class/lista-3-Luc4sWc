package ifsc.poo.login;

public class Usuario {
    String login;
    String senha;

    void setLogin(String login){
        this.login = login;
    }

    void setSenha(String senha){
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean equals(Object o){
        if( !(o instanceof Usuario u)) return false;
        return u.getLogin().equals(this.login);
    }

    public int hashCode(){
        return this.login.hashCode();
    }

    public Usuario(String login, String senha){
        if(login.equals(null)) {
            System.out.println("Login Inválido");
            login = "usuario";
        }
        if(senha.equals(null)){
            System.out.println("Senha Inválida");
            senha = "senha";
        }

        this.login = login;
        this.senha = senha;
    }

}
