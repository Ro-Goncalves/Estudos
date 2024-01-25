package br.com.alura.mypets.domain.abrigo.application.model;

public class SalvarAbrigoCommand {    
    private String nome;
    private String telefone;
    private String email;

    public SalvarAbrigoCommand(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
