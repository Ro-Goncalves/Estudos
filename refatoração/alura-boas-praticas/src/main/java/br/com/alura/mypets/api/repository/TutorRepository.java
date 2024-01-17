package br.com.alura.mypets.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mypets.api.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);

}
