package br.com.mypets.infrastructure.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import br.com.mypets.infrastructure.ClientHttpConfiguration;
import br.com.mypets.infrastructure.model.GetRequest;
import br.com.mypets.infrastructure.model.PostRequest;

public class ClientHttpConfigurationIntegrationTest {
    
    private ClientHttpConfiguration client;

    @BeforeEach
    void setUp(){
        this.client = new ClientHttpConfiguration();
    }

    @Test
    void quandoRealizarUmaRequisicaoGet_deveRetornarResultadoEsperado(){
        //Given
        var getRequest = new GetRequest("abrigos");

        //When
        var response = client.handle(getRequest);

        //Then
        assertThat(response.getStatusCode(), is(equalTo(200)));
    }

    @Test
    void quandoRealizarUmaRequisicaoPost_deveRealziarComSucesso(){
        //Given
        var postRequest = new PostRequest("abrigos", "{\"nome\": \"Nome Abrigo\", \"telefone\": \"4312341234\", \"email\": \"emailabrigo@email.com\"}");
        
        //Then
        var response = client.handle(postRequest);

        //Then
        System.out.println(response.getResponseBody());
        assertThat(response.getStatusCode(), is(equalTo(200)));
    }
}
