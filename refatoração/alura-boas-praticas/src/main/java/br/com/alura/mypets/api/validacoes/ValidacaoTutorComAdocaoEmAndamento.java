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
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitadaoAdocao{
    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto){
        var tutor = tutorRepository.getReferenceById(dto.idTutor());
        List<Adocao> adocoes = repository.findAll();

        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}
