package br.metodista.ads.modelos;

/**
 *
 * @author Luiz Fernando de Souza ADS - EAD Sorocaba Matricula: 225272
 */
public class Usuario {

    private Long id;
    private String nome;
    private String login;
    private String senha;

    public Usuario() {

    }

    public Usuario(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(Long id, String nome, String login) {
        this.id = id;
        this.nome = nome;
        this.login = login;
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
 

    

//    public Object[] carregarGrid() {
//
//        return new Object[]{nome, login};
//
//    }
    @Override
    public String toString() {
        return "\nID: " + id + "\nNome: " + nome + "\nLogin: " + login;
    }

}
