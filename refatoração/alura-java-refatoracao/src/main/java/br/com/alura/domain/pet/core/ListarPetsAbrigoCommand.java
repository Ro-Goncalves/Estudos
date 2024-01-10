package br.com.alura.domain.pet.core;

import br.com.alura.Command;
import br.com.alura.infrastructure.ClientHttpConfiguration;

public class ListarPetsAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            var clientHttp = new ClientHttpConfiguration();        
            var petService = new PetService(clientHttp);

            petService.listarPetsAbrigo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
