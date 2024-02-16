package br.com.alura.adopet.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;

public class CalculadoraProbabilidadeAdocaoTest {
    @Test
    void quandoPetGatoPesoBaixoIdadeBaixa_deveRetornarProbabilidadeAlta() {
        //Given
        var calculador = new CalculadoraProbabilidadeAdocao();

        //When
        var probabilidade = calculador.calcular(new Pet(
            new CadastroPetDto(TipoPet.GATO, "Nome Pet", "Raça Pet", 4, "Cor Pet", 4.0f),
            new Abrigo(new CadastroAbrigoDto("Nome Abrigo", "Telefone Abrigo", "E-Mail Abrigo"))
        ));

        //Then
        assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    @Test
    void quandoPetGatoPesoBaixoIdadeAuta_deveRetornarProbabilidadeMedia() {
        var calculador = new CalculadoraProbabilidadeAdocao();
        var probabilidade = calculador.calcular(new Pet(
            new CadastroPetDto(TipoPet.GATO, "Nome Pet", "Raça Pet", 15, "Cor Pet", 4.0f),
            new Abrigo(new CadastroAbrigoDto("Nome Abrigo", "Telefone Abrigo", "E-Mail Abrigo"))
        ));

        assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }
}
