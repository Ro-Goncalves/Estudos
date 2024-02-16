package br.com.alura.mypets.domain.pet.core.model;

public class SalvarPetCommand {
    private Long idAbrigo;
    private String tipo;
    private String nome;
    private String raca;
    private Integer idade;
    private String cor;
    private Float peso;
    
    public SalvarPetCommand(Long idAbrigo, String tipo, String nome, String raca, Integer idade, String cor, Float peso) {
        this.idAbrigo = idAbrigo;
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public Float getPeso() {
        return peso;
    }

    public Long getIdAbrigo() {
        return idAbrigo;
    }
    
}
