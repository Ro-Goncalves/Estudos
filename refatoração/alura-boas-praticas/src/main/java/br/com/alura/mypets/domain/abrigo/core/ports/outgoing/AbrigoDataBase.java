package br.com.alura.mypets.domain.abrigo.core.ports.outgoing;

import java.util.List;

import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;
import br.com.alura.mypets.domain.pet.core.model.Pet;

public interface AbrigoDataBase {
    void salvar(Abrigo abrigo);
    List<Abrigo> getAllAbrigos();
    List<Pet> getPetsAbrigo(String idOuNome);
    void salvar(Pet pet, String idOuNome);
}
