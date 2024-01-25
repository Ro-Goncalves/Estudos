package br.com.alura.mypets.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mypets.domain.pet.core.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
