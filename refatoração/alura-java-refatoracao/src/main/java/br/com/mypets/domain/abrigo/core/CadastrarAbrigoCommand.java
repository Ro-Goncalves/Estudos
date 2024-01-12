package br.com.mypets.domain.abrigo.core;

import br.com.mypets.Command;
import br.com.mypets.infrastructure.ClientHttpConfiguration;

public class CadastrarAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            var clientHttp = new ClientHttpConfiguration();
            var abrigoService = new AbrigoService(clientHttp); 
            abrigoService.cadastrarAbrigo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
