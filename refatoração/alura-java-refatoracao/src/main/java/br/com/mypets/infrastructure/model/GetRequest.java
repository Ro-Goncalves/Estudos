package br.com.mypets.infrastructure.model;

public class GetRequest {
    private String feature;

    public GetRequest(String feature){
        this.feature = feature;
    }

    public String getUri() {
        return GetUri.getUri(feature);
    }

}
