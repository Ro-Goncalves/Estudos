package br.com.alura.mypets.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.repository.PetRepository;
import br.com.alura.mypets.api.service.ValidacaoException;

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