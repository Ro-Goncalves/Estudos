package br.com.mypets.domain.abrigo.core.model;

import java.util.List;

import br.com.mypets.domain.pet.core.model.Pet;

public class Abrigo {
    private String nome;
    private String telefone;
    private String email;
    private Long id;
    private List<Pet> pets;

    public Abrigo() {}

    public Abrigo(String nome, String telefone, String email) {
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

    public Long getId() {
        return id;
    }

    public List<Pet> getPets() {
        return pets;
    } 
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return """
                "id":%s, "nome":"%s", "telefone":"%s", "email":"%s"
                """.formatted(this.id, this.nome, this.telefone, this.email);
    }
}
