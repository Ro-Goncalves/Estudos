package br.com.alura.mypets.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.mypets.domain.abrigo.core.AbrigoFacade;
import br.com.alura.mypets.domain.abrigo.core.ports.incoming.ConsultaTodosAbrigos;
import br.com.alura.mypets.domain.abrigo.core.ports.incoming.SalvaAbrigo;
import br.com.alura.mypets.domain.abrigo.core.ports.outgoing.AbrigoDataBase;
import br.com.alura.mypets.domain.abrigo.infrastructure.AbrigoDataBaseAdapter;
import br.com.alura.mypets.domain.abrigo.infrastructure.AbrigoRepository;

@Configuration
public class AbrigoDomainConfig {
    
    @Bean
    public AbrigoDataBase abrigoDataBase(AbrigoRepository abrigoRepository){
        return new AbrigoDataBaseAdapter(abrigoRepository);
    }

    @Bean
    public SalvaAbrigo salvaAbrigo(AbrigoDataBase abrigoDataBase){
        return new AbrigoFacade(abrigoDataBase);
    }

    @Bean
    public ConsultaTodosAbrigos consultaTodosAbrigos(AbrigoDataBase abrigoDataBase){
        return new AbrigoFacade(abrigoDataBase);
    }
}
