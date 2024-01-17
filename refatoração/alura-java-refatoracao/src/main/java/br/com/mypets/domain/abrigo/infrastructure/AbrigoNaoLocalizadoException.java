package br.com.mypets.domain.abrigo.infrastructure;

public class AbrigoNaoLocalizadoException extends RuntimeException{
    
    public AbrigoNaoLocalizadoException(String mensagem){
        super(mensagem);
    }    
}
