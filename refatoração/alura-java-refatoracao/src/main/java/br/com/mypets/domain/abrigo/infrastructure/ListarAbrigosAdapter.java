package br.com.mypets.domain.abrigo.infrastructure;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mypets.domain.abrigo.core.model.Abrigo;
import br.com.mypets.domain.abrigo.core.ports.outgoing.ListarAbrigos;

public class ListarAbrigosAdapter implements ListarAbrigos {

    @Override
    public List<Abrigo> handle() {
        String uri = "http://localhost:8080/abrigos";        
        String responseBody = client.dispararRequisicaoGet(uri).body();
        var arrayAbrigos = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        return Arrays.stream(arrayAbrigos).toList();
    }
    
}
