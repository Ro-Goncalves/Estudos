package br.com.mypets.infrastructure.model;

public class PostRequest {
    private String feature;
    private String requestBody;

    public PostRequest(String feature, String requestBody) {
        this.feature = feature;
        this.requestBody = requestBody;
    }

    public String getUri() {
        return GetUri.getUri(feature);
    }

    public String getRequestBody() {
        return this.requestBody;
    }

}
