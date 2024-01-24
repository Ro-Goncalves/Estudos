package br.com.alura.mypets.domain.abrigo.core.ports.incoming;

import br.com.alura.mypets.domain.abrigo.application.model.SalvarAbrigoCommand;

public interface SalvaAbrigo {
    void handle(SalvarAbrigoCommand command);
}
