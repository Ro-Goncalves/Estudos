package br.com.alura.mypets.domain.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mypets.api.repository.PetRepository;
import br.com.alura.mypets.domain.pet.core.model.Pet;
import br.com.alura.mypets.domain.pet.core.model.SalvarPetCommand;
import br.com.alura.mypets.domain.pet.core.ports.incoming.SalvaPet;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pets")
public class PetController {

    private SalvaPet salvaPet;

    public PetController(SalvaPet salvaPet) {
        this.salvaPet = salvaPet;
    }

    @PostMapping("")
    public ResponseEntity<String> addNewPet(@RequestBody SalvarPetCommand salvarPetCommand) {
        var idNewPet = salvaPet.handle(salvarPetCommand);
        return new ResponseEntity<String>("New Pet was added to MyPets, id_pet: " + idNewPet, HttpStatus.CREATED);
    }
    

    // @Autowired
    // private PetRepository repository;

    // @GetMapping
    // public ResponseEntity<List<Pet>> listarTodosDisponiveis() {
    //     List<Pet> pets = repository.findAll();
    //     List<Pet> disponiveis = new ArrayList<>();
    //     for (Pet pet : pets) {
    //         if (pet.getAdotado() == false) {
    //             disponiveis.add(pet);
    //         }
    //     }
    //     return ResponseEntity.ok(disponiveis);
    // }

}
