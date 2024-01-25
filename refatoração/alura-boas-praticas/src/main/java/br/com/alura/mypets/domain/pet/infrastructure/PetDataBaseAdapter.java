package br.com.alura.mypets.domain.pet.infrastructure;

import br.com.alura.mypets.domain.pet.core.model.Pet;
import br.com.alura.mypets.domain.pet.core.ports.outgoing.PetDataBase;

public class PetDataBaseAdapter implements PetDataBase{

    private PetRepository petRepository;

    public PetDataBaseAdapter(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Long salvar(Pet pet) {
        var newPet = petRepository.save(pet);
        return newPet.getId();
    }
    
}
