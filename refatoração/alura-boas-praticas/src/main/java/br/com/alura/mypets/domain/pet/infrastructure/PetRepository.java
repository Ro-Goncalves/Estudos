package br.com.alura.mypets.domain.pet.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mypets.domain.pet.core.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
    
}
