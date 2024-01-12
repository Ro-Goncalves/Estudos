package br.com.mypets.infrastructure.model.exception;

public class ClientException extends RuntimeException {
    public ClientException(Throwable cause){
        super(cause);
    }
}
