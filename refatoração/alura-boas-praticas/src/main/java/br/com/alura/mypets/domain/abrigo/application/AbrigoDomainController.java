package br.com.alura.mypets.domain.abrigo.application;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import br.com.alura.mypets.api.model.Pet;
import br.com.alura.mypets.domain.abrigo.application.model.SalvarAbrigoCommand;
import br.com.alura.mypets.domain.abrigo.core.AbrigoFacade;
import br.com.alura.mypets.domain.abrigo.core.model.Abrigo;
import br.com.alura.mypets.domain.abrigo.core.ports.incoming.SalvaAbrigo;
import br.com.alura.mypets.domain.abrigo.infrastructure.AbrigoRepository;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoDomainController {

    @Qualifier("SalvaAbrigo")
    private final SalvaAbrigo salvaAbrigo;
    // @GetMapping
    // public ResponseEntity<List<Abrigo>> listar() {
    //     return ResponseEntity.ok(repository.findAll());
    // }

    public AbrigoDomainController(SalvaAbrigo salvaAbrigo) {
        this.salvaAbrigo = salvaAbrigo;
    }

    @PostMapping("")
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody SalvarAbrigoCommand command) {
        try {
            salvaAbrigo.handle(command);
            return new ResponseEntity<>("O abrigo foi cadastrado com sucesso", HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>("O abrigo não foi cadastrado - " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }       
    }
    

    // @GetMapping("/{idOuNome}/pets")
    // public ResponseEntity<List<Pet>> listarPets(@PathVariable String idOuNome) {
    //     try {
    //         Long id = Long.parseLong(idOuNome);
    //         List<Pet> pets = repository.getReferenceById(id).getPets();
    //         return ResponseEntity.ok(pets);
    //     } catch (EntityNotFoundException enfe) {
    //         return ResponseEntity.notFound().build();
    //     } catch (NumberFormatException e) {
    //         try {
    //             List<Pet> pets = repository.findByNome(idOuNome).getPets();
    //             return ResponseEntity.ok(pets);
    //         } catch (EntityNotFoundException enfe) {
    //             return ResponseEntity.notFound().build();
    //         }
    //     }
    // }

    // @PostMapping("/{idOuNome}/pets")
    // @Transactional
    // public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid Pet pet) {
    //     try {
    //         Long id = Long.parseLong(idOuNome);
    //         Abrigo abrigo = repository.getReferenceById(id);
    //         pet.setAbrigo(abrigo);
    //         pet.setAdotado(false);
    //         abrigo.getPets().add(pet);
    //         repository.save(abrigo);
    //         return ResponseEntity.ok().build();
    //     } catch (EntityNotFoundException enfe) {
    //         return ResponseEntity.notFound().build();
    //     } catch (NumberFormatException nfe) {
    //         try {
    //             Abrigo abrigo = repository.findByNome(idOuNome);
    //             pet.setAbrigo(abrigo);
    //             pet.setAdotado(false);
    //             abrigo.getPets().add(pet);
    //             repository.save(abrigo);
    //             return ResponseEntity.ok().build();
    //         } catch (EntityNotFoundException enfe) {
    //             return ResponseEntity.notFound().build();
    //         }
    //     }
    // }

}
