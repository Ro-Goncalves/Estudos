package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

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
