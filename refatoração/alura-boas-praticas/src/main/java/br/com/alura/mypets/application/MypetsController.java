package br.com.alura.mypets.application;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class MypetsController {

    @GetMapping("")
    public String getAppRoot() {
        return new String("My Pets REST API");
    }
}
