package br.com.alura.mypets.domain.tutor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import br.com.alura.mypets.api.model.Tutor;
import br.com.alura.mypets.api.repository.TutorRepository;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    // @Autowired
    // private TutorRepository repository;

    // @PostMapping
    // @Transactional
    // public ResponseEntity<String> cadastrar(@RequestBody @Valid Tutor tutor) {
    //     boolean telefoneJaCadastrado = repository.existsByTelefone(tutor.getTelefone());
    //     boolean emailJaCadastrado = repository.existsByEmail(tutor.getEmail());

    //     if (telefoneJaCadastrado || emailJaCadastrado) {
    //         return ResponseEntity.badRequest().body("Dados já cadastrados para outro tutor!");
    //     } else {
    //         repository.save(tutor);
    //         return ResponseEntity.ok().build();
    //     }
    // }

    // @PutMapping
    // @Transactional
    // public ResponseEntity<String> atualizar(@RequestBody @Valid Tutor tutor) {
    //     repository.save(tutor);
    //     return ResponseEntity.ok().build();
    // }

}
