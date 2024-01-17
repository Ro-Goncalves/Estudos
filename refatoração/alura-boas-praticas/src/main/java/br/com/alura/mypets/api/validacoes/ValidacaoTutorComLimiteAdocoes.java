package br.com.alura.mypets.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.model.Adocao;
import br.com.alura.mypets.api.model.StatusAdocao;
import br.com.alura.mypets.api.repository.AdocaoRepository;
import br.com.alura.mypets.api.repository.TutorRepository;
import br.com.alura.mypets.api.service.ValidacaoException;

@Component
public class ValidacaoTutorComLimiteAdocoes implements ValidacaoSolicitadaoAdocao{
    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto){
        List<Adocao> adocoes = repository.findAll();
        var tutor = tutorRepository.getReferenceById(dto.idTutor());
        
        for (Adocao a : adocoes) {
            int contador = 0;
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.APROVADO) {
                contador = contador + 1;
            }
            if (contador == 5) {
                throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
            }
        }
    }
}
