package br.com.alura.mypets.domain.abrigo.core;

import br.com.alura.mypets.domain.abrigo.application.model.SalvarAbrigoCommand;
import br.com.alura.mypets.domain.abrigo.core.model.Converter;
import br.com.alura.mypets.domain.abrigo.core.ports.incoming.SalvaAbrigo;
import br.com.alura.mypets.domain.abrigo.infrastructure.AbrigoDataBaseAdapter;

public class AbrigoFacade implements SalvaAbrigo{
    
    private AbrigoDataBaseAdapter adapter;

    public AbrigoFacade(AbrigoDataBaseAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void handle(SalvarAbrigoCommand command) {        
        adapter.salvar(Converter.toAbrigo(command));
    }
}
