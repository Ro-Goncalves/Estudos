package br.com.alura.mypets.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mypets.api.model.Adocao;
import br.com.alura.mypets.api.model.StatusAdocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
    boolean existsByPetIdAndStatus(Long id, StatusAdocao status);
}
