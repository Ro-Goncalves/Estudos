package br.com.alura.mypets.domain.pet.core.ports.incoming;

import br.com.alura.mypets.domain.pet.core.model.SalvarPetCommand;

public interface SalvaPet {
    Long handle(SalvarPetCommand salvarpetCommand);
}
