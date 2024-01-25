package br.com.alura.mypets.domain.abrigo.core.model;

import br.com.alura.mypets.domain.abrigo.application.model.AbrigoDto;
import br.com.alura.mypets.domain.abrigo.application.model.SalvarAbrigoCommand;

public class AbrigoConverter {

    public static Abrigo toAbrigo(SalvarAbrigoCommand command) {
        return new Abrigo(
            command.getNome(), 
            command.getTelefone(), 
            command.getEmail()
        );
    }

    public static AbrigoDto toAbrigoDto(Abrigo abrigo){
        return new AbrigoDto(
            abrigo.getId(), 
            abrigo.getNome(), 
            abrigo.getTelefone(), 
            abrigo.getEmail()
        );
    }

}
