package br.com.mypets.domain.pet.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mypets.domain.pet.core.model.Pet;
import br.com.mypets.infrastructure.ClientHttpConfiguration;

public class PetService {
    ClientHttpConfiguration client;
    
    public PetService(ClientHttpConfiguration client) {
        this.client = client;
    }

    public void listarPetsAbrigo() throws Exception{
        System.out.println("Digite o id ou nome do abrigo:");
        String idOuNome = new Scanner(System.in).nextLine();
        
        String uri = "http://localhost:8080/abrigos/" +idOuNome +"/pets";        
        HttpResponse<String> response = client.dispararRequisicaoGet(uri);
        int statusCode = response.statusCode();
        if (statusCode == 404 || statusCode == 500) {
            System.out.println("ID ou nome não cadastrado!");
        }
        String responseBody = response.body();
        var arrayPets = new ObjectMapper().readValue(responseBody, Pet[].class);
        var listPets = Arrays.stream(arrayPets).toList();
        System.out.println("Pets cadastrados:");
        for (Pet pet : listPets) {
           
            long id =pet.getId();
            String tipo = pet.getTipo();
            String nome = pet.getNome();
            String raca = pet.getRaca();
            int idade = pet.getIdade();
            System.out.println(id +" - " +tipo +" - " +nome +" - " +raca +" - " +idade +" ano(s)");
        }
    }

    public void importarPetsAbrigo() throws Exception{
        System.out.println("Digite o id ou nome do abrigo:");
        String idOuNome = new Scanner(System.in).nextLine();

        System.out.println("Digite o nome do arquivo CSV:");
        String nomeArquivo = new Scanner(System.in).nextLine();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " +nomeArquivo);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            String tipo = campos[0];
            String nome = campos[1];
            String raca = campos[2];
            int idade = Integer.parseInt(campos[3]);
            String cor = campos[4];
            Float peso = Float.parseFloat(campos[5]);

            var pet = new Pet(tipo, nome, raca, idade, cor, peso);
            
            String uri = "http://localhost:8080/abrigos/" + idOuNome + "/pets";
           
            HttpResponse<String> response = client.dispararRequisicaoPost(uri, pet);
            int statusCode = response.statusCode();
            String responseBody = response.body();
            if (statusCode == 200) {
                System.out.println("Pet cadastrado com sucesso: " + nome);
            } else if (statusCode == 404) {
                System.out.println("Id ou nome do abrigo não encontado!");
                break;
            } else if (statusCode == 400 || statusCode == 500) {
                System.out.println("Erro ao cadastrar o pet: " + nome);
                System.out.println(responseBody);
                break;
            }
        }
        reader.close();
    }    
}
