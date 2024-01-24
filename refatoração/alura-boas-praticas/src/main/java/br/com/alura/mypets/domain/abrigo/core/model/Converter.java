package br.com.alura.mypets.domain.abrigo.core.model;

import br.com.alura.mypets.domain.abrigo.application.model.SalvarAbrigoCommand;

public class Converter {

    public static Abrigo toAbrigo(SalvarAbrigoCommand command) {
        return new Abrigo(command.getNome(), command.getTelefone(), command.getEmail());
    }

}
