package br.com.alura.adopet.api.service;

import static br.com.alura.adopet.api.support.ClassesCriator.createPet;
import static br.com.alura.adopet.api.support.ClassesCriator.createTutor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoSolicitacaoAdocao;

@ExtendWith(MockitoExtension.class)
public class AdocaoServiceTest {

    @InjectMocks
    private AdocaoService service;

    @Mock
    private AdocaoRepository mockeddocaoRepository;

    @Mock
    private PetRepository mockedPetRepository;

    @Mock
    private TutorRepository mockedTutorRepository;

    @Mock
    private EmailService mockedEmailService;

    @Spy
    private List<ValidacaoSolicitacaoAdocao> spyValidacoes = new ArrayList<>();

    @Mock
    private ValidacaoSolicitacaoAdocao validacaoSolicitacaoAdocao1;

    @Mock
    private ValidacaoSolicitacaoAdocao validacaoSolicitacaoAdocao2;

    @Captor
    private ArgumentCaptor<Adocao> captorAdocao;

    @Captor
    private ArgumentCaptor<Long> captorId;

    @Test
    @SuppressWarnings("null")
    void quandoSolicitar_deveSalvarAdocao(){
        //Given
        var dto = new SolicitacaoAdocaoDto(1L, 2L, "Motivo Adoção");
        var expectedPet = createPet();
        var expectedTutor = createTutor();

        when(mockedPetRepository.getReferenceById(Mockito.anyLong())).thenReturn(expectedPet);
        when(mockedTutorRepository.getReferenceById(Mockito.anyLong())).thenReturn(expectedTutor);
        
        
        //When
        service.solicitar(dto);

        //Then        
        verify(mockedPetRepository).getReferenceById(captorId.capture());
        var idPetActual = captorId.getValue();
        assertEquals(dto.idPet(), idPetActual);

        verify(mockedTutorRepository).getReferenceById(captorId.capture());
        var idTutorActual = captorId.getValue();
        assertEquals(dto.idTutor(), idTutorActual);

        verify(mockeddocaoRepository).save(captorAdocao.capture());
        var actualAdocao = captorAdocao.getValue();

        assertEquals(expectedPet, actualAdocao.getPet());
        assertEquals(expectedTutor, actualAdocao.getTutor());
        assertEquals(dto.motivo(), actualAdocao.getMotivo());
    }

    @Test   
    void quandoSolicitar_deveChamarValidadores(){
        //Given
        var dto = new SolicitacaoAdocaoDto(1L, 2L, "Motivo Adoção");
        var expectedPet = createPet();
        var expectedTutor = createTutor();

        spyValidacoes.add(validacaoSolicitacaoAdocao1);
        spyValidacoes.add(validacaoSolicitacaoAdocao2);

        when(mockedPetRepository.getReferenceById(Mockito.anyLong())).thenReturn(expectedPet);
        when(mockedTutorRepository.getReferenceById(Mockito.anyLong())).thenReturn(expectedTutor);        
        
        //When
        service.solicitar(dto);

        //Then
        BDDMockito.then(validacaoSolicitacaoAdocao1).should().validar(dto);
        verify(validacaoSolicitacaoAdocao2).validar(dto);
    }
    
}
