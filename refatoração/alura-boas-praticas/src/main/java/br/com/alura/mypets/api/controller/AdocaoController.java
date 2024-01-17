package br.com.alura.mypets.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import br.com.alura.mypets.api.dto.AprovacaoAdocaoDto;
import br.com.alura.mypets.api.dto.ReprovacaoAdocaoDto;
import br.com.alura.mypets.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.mypets.api.service.AdocaoService;
import br.com.alura.mypets.api.service.ValidacaoException;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService; 
    

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoAdocaoDto dto) {
        try {            
            this.adocaoService.solicitar(dto);
            return ResponseEntity.ok("Adoção solicitada com sucesso");
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovacaoAdocaoDto dto) {        
        this.adocaoService.aprovar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovacaoAdocaoDto dto) {
        this.adocaoService.reprovar(dto);
        return ResponseEntity.ok().build();
    }

}
