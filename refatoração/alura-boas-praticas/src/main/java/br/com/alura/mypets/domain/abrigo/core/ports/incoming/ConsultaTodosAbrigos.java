package br.com.alura.mypets.domain.abrigo.core.ports.incoming;

import java.util.List;

import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;

public interface ConsultaTodosAbrigos {
    List<Abrigo> handle();
}
