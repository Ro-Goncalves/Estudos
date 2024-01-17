package br.com.alura.mypets.api.validacoes;

import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitadaoAdocao {
    void validar(SolicitacaoAdocaoDto dto);
}
