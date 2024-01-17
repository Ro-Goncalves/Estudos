package br.com.alura.mypets.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.model.Adocao;
import br.com.alura.mypets.api.model.StatusAdocao;
import br.com.alura.mypets.api.repository.AdocaoRepository;
import br.com.alura.mypets.api.repository.PetRepository;
import br.com.alura.mypets.api.service.ValidacaoException;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitadaoAdocao{
    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto){
        var pet = petRepository.getReferenceById(dto.idPet());
        List<Adocao> adocoes = repository.findAll();
        
        for (Adocao a : adocoes) {
            if (a.getPet() == pet && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
            }
        }
    }
}
