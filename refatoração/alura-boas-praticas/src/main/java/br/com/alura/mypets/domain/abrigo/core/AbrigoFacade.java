package br.com.alura.mypets.domain.abrigo.core;

import java.util.List;

import br.com.alura.mypets.domain.abrigo.application.model.SalvarAbrigoCommand;
import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;
import br.com.alura.mypets.domain.abrigo.core.model.AbrigoConverter;
import br.com.alura.mypets.domain.abrigo.core.ports.incoming.ConsultaTodosAbrigos;
import br.com.alura.mypets.domain.abrigo.core.ports.incoming.SalvaAbrigo;
import br.com.alura.mypets.domain.abrigo.core.ports.outgoing.AbrigoDataBase;

public class AbrigoFacade implements SalvaAbrigo, ConsultaTodosAbrigos{
    
    private AbrigoDataBase dataBase;

    public AbrigoFacade(AbrigoDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void handle(SalvarAbrigoCommand command) {        
        dataBase.salvar(AbrigoConverter.toAbrigo(command));
    }

    @Override
    public List<Abrigo> handle() {
        return dataBase.getAllAbrigos();
    }
}
