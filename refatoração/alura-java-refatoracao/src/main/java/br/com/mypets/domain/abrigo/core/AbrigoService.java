package br.com.mypets.domain.abrigo.core;

import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mypets.domain.abrigo.core.model.Abrigo;
import br.com.mypets.infrastructure.ClientHttpConfiguration;

public class AbrigoService {
    private ClientHttpConfiguration client;

    public AbrigoService(ClientHttpConfiguration client) {
        this.client = client;
    }

    public void cadastrarAbrigo() throws Exception{
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        var abrigo = new Abrigo(nome, telefone, email);
        
        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.dispararRequisicaoPost(uri, abrigo);

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }

    public void listarAbrigo() throws Exception{       ;
        // String uri = "http://localhost:8080/abrigos";        
        // String responseBody = client.dispararRequisicaoGet(uri).body();
        // var arrayAbrigos = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        // var listAbrigos = Arrays.stream(arrayAbrigos).toList();
        if (listAbrigos.isEmpty()) {
            System.out.println("Não há Abrigos cadastrados");
        } else {
           mostrarAbrigos(listAbrigos);
        }
    }

    private void mostrarAbrigos(List<Abrigo> listAbrigos){
        System.out.println("Abrigos cadastrados:");
        for (Abrigo abrigo : listAbrigos) {            
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println(id +" - " +nome);
        }
    }
}
