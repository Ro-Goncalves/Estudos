package br.com.alura.mypets.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.alura.mypets.domain.pet.core.PetFacade;
import br.com.alura.mypets.domain.pet.core.ports.incoming.SalvaPet;
import br.com.alura.mypets.domain.pet.core.ports.outgoing.PetDataBase;
import br.com.alura.mypets.domain.pet.infrastructure.PetDataBaseAdapter;
import br.com.alura.mypets.domain.pet.infrastructure.PetRepository;

@Configuration
public class PetDomainConfig {

    @Bean
    public PetDataBase petDataBase(PetRepository petRepository) {
        return new PetDataBaseAdapter(petRepository);
    }
    
    @Bean
    public SalvaPet salvaPet(PetDataBase petDataBase){
        return new PetFacade(petDataBase);
    }
}
