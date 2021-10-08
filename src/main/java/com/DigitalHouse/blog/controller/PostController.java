package com.DigitalHouse.blog.controller;

import com.DigitalHouse.blog.domain.Postagem;
import com.DigitalHouse.blog.repositoy.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*") //qualquer origem vai ser aceita
public class PostController {

    @Autowired //Spring faz a injeção de dependência sozinho porque aqui é uma interface.
    private PostagemRepository repository; //injetanto o repositório.

    @GetMapping //Sempre que vier algo externo através da url será tratado aqui
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
