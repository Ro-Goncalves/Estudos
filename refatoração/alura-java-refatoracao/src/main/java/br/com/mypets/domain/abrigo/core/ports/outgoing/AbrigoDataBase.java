package br.com.mypets.domain.abrigo.core.ports.outgoing;

import java.util.List;

import br.com.mypets.domain.abrigo.core.model.Abrigo;

public interface AbrigoDataBase {
    List<Abrigo> consultarAbrigos();
    Abrigo cadastrarAbrigo(Abrigo abrigo);
}
