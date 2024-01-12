package br.com.mypets.infrastructure.model;

public enum Urls {
    API {
        @Override
        public String get() {
            return "http://localhost:8080/";
        }
    };

    public abstract String get();
}
