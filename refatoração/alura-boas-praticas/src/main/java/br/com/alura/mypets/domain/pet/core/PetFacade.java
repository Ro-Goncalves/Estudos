package br.com.alura.mypets.domain.pet.core;

import br.com.alura.mypets.domain.pet.core.model.PetConverter;
import br.com.alura.mypets.domain.pet.core.model.SalvarPetCommand;
import br.com.alura.mypets.domain.pet.core.ports.incoming.SalvaPet;
import br.com.alura.mypets.domain.pet.core.ports.outgoing.PetDataBase;

public class PetFacade implements SalvaPet{

    private PetDataBase petDataBase;

    public PetFacade(PetDataBase petDataBase) {
        this.petDataBase = petDataBase;
    }

    @Override
    public Long handle(SalvarPetCommand salvarpetCommand) {
        return petDataBase.salvar(PetConverter.toPet(salvarpetCommand));
    }
    
}
