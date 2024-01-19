package br.com.alura.mypets.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.model.StatusAdocao;
import br.com.alura.mypets.api.repository.AdocaoRepository;
import br.com.alura.mypets.api.service.ValidacaoException;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitadaoAdocao{
    @Autowired
    private AdocaoRepository repository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto){        
        if (repository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }
}
