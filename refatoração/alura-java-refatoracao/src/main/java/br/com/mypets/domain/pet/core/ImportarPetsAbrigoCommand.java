package br.com.mypets.domain.pet.core;

import br.com.mypets.Command;
import br.com.mypets.infrastructure.ClientHttpConfiguration;

public class ImportarPetsAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            var clientHttp = new ClientHttpConfiguration();        
            var petService = new PetService(clientHttp);

            petService.importarPetsAbrigo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
