package dominio;

import java.util.Objects;

public class Pessoa {
    private int idpessoa;
    private String nome;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String email){
        super();
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(int idpessoa, String nome, String email) {
        super();
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idpessoa=" + idpessoa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
