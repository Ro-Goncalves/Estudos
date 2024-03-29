package br.com.alura.mypets.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.mypets.api.dto.AprovacaoAdocaoDto;
import br.com.alura.mypets.api.dto.ReprovacaoAdocaoDto;
import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.model.Adocao;
import br.com.alura.mypets.api.model.StatusAdocao;
import br.com.alura.mypets.api.repository.AdocaoRepository;
import br.com.alura.mypets.api.repository.TutorRepository;
import br.com.alura.mypets.api.validacoes.ValidacaoSolicitadaoAdocao;
import br.com.alura.mypets.domain.pet.infrastructure.PetRepository;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private List<ValidacaoSolicitadaoAdocao> validacoes;

    public void solicitar(SolicitacaoAdocaoDto dto){
        var pet = petRepository.getReferenceById(dto.idPet());
        var tutor = tutorRepository.getReferenceById(dto.idTutor());

        validacoes.forEach(E -> E.validar(dto));
        
        var adocao = new Adocao(tutor, pet, dto.motivo());

        repository.save(adocao);

        emailService.enviarEmail(
            adocao.getPet().getIdAbrigo().getEmail(),
            "Solicitação de adoção",
            "Olá " +adocao.getPet().getIdAbrigo().getNome() +"!\n\nUma solicitação de adoção foi registrada hoje para o pet: " +adocao.getPet().getNome() +". \nFavor avaliar para aprovação ou reprovação."
        );
    }

    public void aprovar(AprovacaoAdocaoDto dto){
        var adocao = repository.getReferenceById(dto.idAdocao());
        adocao.marcarComoAprovado();             

        emailService.enviarEmail(
            adocao.getPet().getIdAbrigo().getEmail(),
            "Adoção aprovada",
            "Parabéns " +adocao.getTutor().getNome() +"!\n\nSua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi aprovada.\nFavor entrar em contato com o abrigo " +adocao.getPet().getIdAbrigo().getNome() +" para agendar a busca do seu pet."
        );
    }

    public void reprovar(ReprovacaoAdocaoDto dto){
        var adocao = repository.getReferenceById(dto.idAdocao());
        adocao.marcarComoReprovada(dto.justificativa());      

        emailService.enviarEmail(
            adocao.getPet().getIdAbrigo().getEmail(),
            "Adoção reprovada",
            "Olá " +adocao.getTutor().getNome() +"!\n\nInfelizmente sua adoção do pet " +adocao.getPet().getNome() +", solicitada em " +adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +", foi reprovada pelo abrigo " +adocao.getPet().getIdAbrigo().getNome() +" com a seguinte justificativa: " +adocao.getJustificativaStatus()
        );

    }
}
