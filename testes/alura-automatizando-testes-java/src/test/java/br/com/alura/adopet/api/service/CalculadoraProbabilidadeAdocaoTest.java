package br.com.alura.adopet.api.service;

import static br.com.alura.adopet.api.support.ClassesCriator.createAbrigo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import br.com.alura.adopet.api.support.ClassesCriator;

public class CalculadoraProbabilidadeAdocaoTest {
    
    @Test
    void quandoPetGatoPesoBaixoIdadeBaixa_deveRetornarProbabilidadeAlta() {
        //Given
        var calculador = new CalculadoraProbabilidadeAdocao();

        //When
        var probabilidade = calculador.calcular(new Pet(
            new CadastroPetDto(TipoPet.GATO, "Nome Pet", "Raça Pet", 4, "Cor Pet", 4.0f),
            ClassesCriator.createAbrigo()
        ));

        //Then
        assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    void quandoPetGatoPesoBaixoIdadeAuta_deveRetornarProbabilidadeMedia() {
        var calculador = new CalculadoraProbabilidadeAdocao();
        var probabilidade = calculador.calcular(new Pet(
            new CadastroPetDto(TipoPet.GATO, "Nome Pet", "Raça Pet", 15, "Cor Pet", 4.0f),
            createAbrigo()
        ));

        assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }
}
