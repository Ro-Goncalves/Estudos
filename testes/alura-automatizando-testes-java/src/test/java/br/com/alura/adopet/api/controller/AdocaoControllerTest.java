package br.com.alura.adopet.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.adopet.api.service.AdocaoService;

@SpringBootTest
@AutoConfigureMockMvc
public class AdocaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdocaoService adocaoService;

    @Test
    void quandoSolicitacaoDeAdocaoComErros_deveDevolverCodigo400() throws Exception{
        //Given
        var json = "{}";

        //When
        @SuppressWarnings("null")
        var resultado = mvc.perform(
            post("/adocoes")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Then
        assertEquals(400, resultado.getStatus());
    }

    @Test
    void quandoSolicitacaoDeAdocaoSemErros_deveDevolverCodigo200() throws Exception{
        //Given
        var json = """
                {
                    "idPet":1,
                    "idTutor":1,
                    "motivo":"Motivo de Adocão"
                }
                """;

        //When
        @SuppressWarnings("null")
        var resultado = mvc.perform(
            post("/adocoes")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Then
        assertEquals(200, resultado.getStatus());
    }

    @Test
    void quandoAprovarUmaAdocao_deveRetornarCodigo200() throws Exception {
        //Given
        var json = """
                {
                    "idAdocao":1
                }
                """;

        //When
        @SuppressWarnings("null")
        var resultado = mvc.perform(
            put("/adocoes/aprovar")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Then
        assertEquals(200, resultado.getStatus());
    }

    @Test
    void quandoReprovarUmaAdocao_deveRetornarCodigo200() throws Exception {
        //Given
        var json = """
                {
                    "idAdocao":1,
                    "justificativa": "Cachorro chato de mais"
                }
                """;

        //When
        @SuppressWarnings("null")
        var resultado = mvc.perform(
            put("/adocoes/reprovar")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //Then
        assertEquals(200, resultado.getStatus());
    }

}
