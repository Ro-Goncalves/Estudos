package br.com.mypets.domain.abrigo.infrastructure;

import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mypets.domain.abrigo.core.model.Abrigo;
import br.com.mypets.domain.abrigo.core.ports.outgoing.AbrigoDataBase;
import br.com.mypets.infrastructure.model.GetRequest;
import br.com.mypets.infrastructure.model.PostRequest;
import br.com.mypets.infrastructure.ports.Client;

public class AbrigoDataBaseAdapter implements AbrigoDataBase {
    private Client client;
    

    public AbrigoDataBaseAdapter(Client client) {
        this.client = client;
    }

    @Override
    public List<Abrigo> consultarAbrigos() {
        var getRequest = new GetRequest("abrigos");        
        var clientResponse = client.handle(getRequest);
        
        if (!clientResponse.getStatusCode().equals(200)) {
            throw new AbrigoNaoLocalizadoException("Não há Abrigos cadastrados");
        }
        
        try {
            return new ObjectMapper().readValue(clientResponse.getResponseBody(), new TypeReference<List<Abrigo>>() {});
        } catch (JsonProcessingException e) {
            throw new AbrigoNaoLocalizadoException("Erro ao transformar Json em Abrigo");
        }
    }

    @Override
    public Abrigo cadastrarAbrigo(Abrigo abrigo) {
        var postRequest = new PostRequest("abrigos", new ObjectMapper().writeValueAsString(abrigo));
        var clientResponse = client.handle(postRequest);

        int statusCode = clientResponse.getStatusCode();
        String responseBody = clientResponse.getResponseBody();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }
    
}
