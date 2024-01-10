package br.com.alura.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.domain.abrigo.core.AbrigoService;
import br.com.alura.domain.abrigo.core.model.Abrigo;
import br.com.alura.infrastructure.ClientHttpConfiguration;

public class AbrigoServiceTest {
    private ClientHttpConfiguration client;
    private HttpResponse<String> response;

    private AbrigoService abrigoService;

    @BeforeEach
    void setUp(){        
        this.response = mock(HttpResponse.class);
        this.client = mock(ClientHttpConfiguration.class);
        this.abrigoService = new AbrigoService(client);
    }

    @Test
    void deveVerificarQuandoHaAbrigo() throws Exception{
        //Given
        var abrigo = new Abrigo("Nome", "Telefone", "Email");
        abrigo.setId(0L);
        var expectedAbrigosCadastrados = "Abrigos cadastrados:";
        var expectedIdENome = "0 - Nome";

        var baos = new ByteArrayOutputStream();
        var printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{" + abrigo.toString() + "}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        //When
        abrigoService.listarAbrigo();
        
        //Then
        var lines = baos.toString().split(System.lineSeparator());
        String actualAbrigoCadastrados = lines[0];
        String actualIdENome = lines[1];

        assertEquals(expectedAbrigosCadastrados, actualAbrigoCadastrados);
        assertEquals(expectedIdENome, actualIdENome);

    }

    @Test
    void deveVerificarQuandoNaoHaAbrigo() throws Exception{
        //Given
        var abrigo = new Abrigo("Nome", "Telefone", "Email");
        abrigo.setId(0L);
        var expected = "Não há Abrigos cadastrados";      

        var baos = new ByteArrayOutputStream();
        var printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        //When
        abrigoService.listarAbrigo();
        
        //Then
        var lines = baos.toString().split(System.lineSeparator());
        String actual = lines[0];

        assertEquals(expected, actual);
    }
}
