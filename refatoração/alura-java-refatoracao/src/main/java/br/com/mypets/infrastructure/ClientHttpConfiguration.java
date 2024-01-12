package br.com.mypets.infrastructure;

import static br.com.mypets.infrastructure.InfrastructureConverter.toClientResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.com.mypets.infrastructure.model.ClientRespose;
import br.com.mypets.infrastructure.model.GetRequest;
import br.com.mypets.infrastructure.model.PostRequest;
import br.com.mypets.infrastructure.model.exception.ClientException;
import br.com.mypets.infrastructure.ports.Client;

public class ClientHttpConfiguration implements Client{

    @Override
    public ClientRespose handle(GetRequest getRequest){        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(getRequest.getUri()))
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();

        return toClientResponse(sender(request));
    }

    @Override
    public ClientRespose handle(PostRequest postRequest) {       
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(postRequest.getUri()))
            .header("Content-Type", "application/json")
            .method("POST", HttpRequest.BodyPublishers.ofString(postRequest.getRequestBody()))
            .build();
       
        return toClientResponse(sender(request));
    }

    private HttpResponse<String> sender( HttpRequest request ){
        HttpClient client = HttpClient.newHttpClient();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }
}
