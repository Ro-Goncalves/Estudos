package br.com.alura.adopet.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
    void testAprovar() {

    }

    @Test
    void testReprovar() {

    }

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
}
