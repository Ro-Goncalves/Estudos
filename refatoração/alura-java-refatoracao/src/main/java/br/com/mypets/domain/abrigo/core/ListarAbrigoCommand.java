package br.com.mypets.domain.abrigo.core;

import br.com.mypets.Command;
import br.com.mypets.infrastructure.ClientHttpConfiguration;

public class ListarAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            var clientHttp = new ClientHttpConfiguration();
            var abrigoService = new AbrigoService(clientHttp); 
            abrigoService.listarAbrigo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }
    
}
