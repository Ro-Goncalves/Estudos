package br.com.mypets.infrastructure.model;

public class ClientRespose {
    private Integer statusCode;
    private String responseBody;
    
    public ClientRespose(Integer statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
