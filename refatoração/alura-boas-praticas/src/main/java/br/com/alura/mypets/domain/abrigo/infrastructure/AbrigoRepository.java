package br.com.alura.mypets.domain.abrigo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;

@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    boolean existsByNomeAndTelefoneAndEmail(Abrigo abrigo);    
    Abrigo findByNome(String nome);
}
