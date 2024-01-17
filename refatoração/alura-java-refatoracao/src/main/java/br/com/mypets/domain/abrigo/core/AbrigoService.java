package br.com.mypets.domain.abrigo.core;

import java.util.List;
import java.util.Scanner;

import br.com.mypets.domain.abrigo.core.model.Abrigo;
import br.com.mypets.domain.abrigo.infrastructure.AbrigoDataBaseAdapter;
import br.com.mypets.domain.abrigo.infrastructure.AbrigoNaoLocalizadoException;

public class AbrigoService {
    private AbrigoDataBaseAdapter adapter;

    public AbrigoService(AbrigoDataBaseAdapter adapter) {
        this.adapter = adapter;
    }

    public void cadastrarAbrigo() throws Exception{
        var scanner = new Scanner(System.in);

        System.out.println("Digite o nome do abrigo:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = scanner.nextLine();

        scanner.close();

        var abrigo = new Abrigo(nome, telefone, email);        
        adapter.cadastrarAbrigo(abrigo);
    }

    public void listarAbrigo() throws Exception{
        try {
            var listAbrigos = adapter.consultarAbrigos();    
            if (listAbrigos.isEmpty()) {
                System.out.println("Não há Abrigos cadastrados");
            } else {
               mostrarAbrigos(listAbrigos);
            }            
        } catch (AbrigoNaoLocalizadoException e) {
            System.out.println(e.getMessage());
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
