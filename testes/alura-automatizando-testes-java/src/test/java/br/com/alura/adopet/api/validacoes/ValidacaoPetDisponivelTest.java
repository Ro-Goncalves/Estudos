package br.com.alura.adopet.api.validacoes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;
import br.com.alura.adopet.api.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
public class ValidacaoPetDisponivelTest {

    @InjectMocks
    private ValidacaoPetDisponivel validacao;

    @Mock
    private PetRepository mockedPetRepository;


    @Test
    void quandoReceberPet_devePermitirSolicitacaoAdocao() {        
       //Given
        var dto = createSolicitacaoAdocaoDto();
        var pet = createPet();

        when(mockedPetRepository.getReferenceById(anyLong())).thenReturn(pet);

        //When - Then
        assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    void quandoReceberPet_deveValidarAdocao() {        
        //Given    
        var dto = createSolicitacaoAdocaoDto();
        var pet = createPet();
        pet.setAdotado(Boolean.TRUE);

        when(mockedPetRepository.getReferenceById(anyLong())).thenReturn(pet);

        //When - Then
        assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }

    private SolicitacaoAdocaoDto createSolicitacaoAdocaoDto(){
        return new SolicitacaoAdocaoDto(
            1L,
            1L,
            "Motivo DTO"
        );
    }

    private Pet createPet(){
        return new Pet(
            new CadastroPetDto(TipoPet.CACHORRO, "Nome Pet", "Raça Pet", 1, "Cor Pet", 1f),
            new Abrigo()
        );
    }
}
