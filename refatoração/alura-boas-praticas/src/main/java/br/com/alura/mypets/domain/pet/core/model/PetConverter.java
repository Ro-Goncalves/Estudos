package br.com.alura.mypets.domain.pet.core.model;

public class PetConverter {

    public static Pet toPet(SalvarPetCommand command) {        
        return new Pet(
            TipoPet.valueOf(command.getTipo()), 
            command.getNome(), 
            command.getRaca(), 
            command.getIdade(), 
            command.getCor(), 
            command.getPeso());
    }

}
