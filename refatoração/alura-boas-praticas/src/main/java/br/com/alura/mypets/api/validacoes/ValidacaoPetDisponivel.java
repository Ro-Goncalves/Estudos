package br.com.alura.mypets.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.service.ValidacaoException;
import br.com.alura.mypets.domain.pet.infrastructure.PetRepository;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitadaoAdocao{

    @Autowired
    private PetRepository petRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto){
        var pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}