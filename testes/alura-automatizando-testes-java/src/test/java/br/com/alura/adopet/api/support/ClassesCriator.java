package br.com.alura.adopet.api.support;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.dto.CadastroTutorDto;
import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;
import br.com.alura.adopet.api.model.Tutor;

public class ClassesCriator {
    
    public static Pet createPet(){
        return new Pet(
            createCadastroPetDto(),
            createAbrigo()
        );
    } 
    
    public static SolicitacaoAdocaoDto createSolicitacaoAdocaoDto(){
        return new SolicitacaoAdocaoDto(
            1L,
            1L,
            "Motivo DTO"
        );
    }

    public static CadastroPetDto createCadastroPetDto(){
        return new CadastroPetDto(TipoPet.GATO, "Nome Pet", "Raça Pet", 4, "Cor Pet", 4.0f);
    }

    public static CadastroAbrigoDto createCadastroAbrigoDto(){
        return new CadastroAbrigoDto("Nome Abrigo", "Telefone Abrigo", "E-Mail Abrigo");
    }

    public static Abrigo createAbrigo(){
        return new Abrigo(createCadastroAbrigoDto());
    }

    public static Tutor createTutor(){
        return new Tutor(new CadastroTutorDto("Nome Tutor", "999999999", "emailtutor@teste.com"));
    }
}
