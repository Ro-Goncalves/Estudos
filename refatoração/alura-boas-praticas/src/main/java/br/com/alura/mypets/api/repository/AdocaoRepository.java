package br.com.alura.mypets.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mypets.api.model.Adocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

}
