package br.com.mypets.infrastructure.model;

import static br.com.mypets.infrastructure.model.Urls.API;

public class GetUri {
    public static String getUri(String feature) {
        return API.get() + feature;
    }
}
