package br.com.mypets.infrastructure;

import java.net.http.HttpResponse;

import br.com.mypets.infrastructure.model.ClientRespose;

public class InfrastructureConverter {

    public static ClientRespose toClientResponse(HttpResponse<String> httpResponse) {
        return new ClientRespose(httpResponse.statusCode(), httpResponse.body());
    }

}
