package br.com.alura.mypets.domain.pet.core.ports.outgoing;

import br.com.alura.mypets.domain.pet.core.model.Pet;

public interface PetDataBase {
    Long salvar(Pet pet);
}
