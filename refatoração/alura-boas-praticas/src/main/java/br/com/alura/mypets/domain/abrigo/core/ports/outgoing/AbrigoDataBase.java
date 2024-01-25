package br.com.alura.mypets.domain.abrigo.core.ports.outgoing;

import java.util.List;

import br.com.alura.mypets.api.model.Pet;
import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;

public interface AbrigoDataBase {
    void salvar(Abrigo abrigo);
    List<Abrigo> getAllAbrigos();
    List<Pet> getPetsAbrigo(String idOuNome);
    void salvar(Pet pet, String idOuNome);
}
