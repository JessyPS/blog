package com.DigitalHouse.blog.controller;

import com.DigitalHouse.blog.model.Postagem;
import com.DigitalHouse.blog.repositoy.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/postagens") //endpoint
@CrossOrigin("*") //qualquer origem vai ser aceita.
public class PostController {

    @Autowired //Spring faz a injeção de dependência sozinho porque aqui é uma interface.
    private PostagemRepository repository; //injetanto o repositório.

    @GetMapping //Sempre que vier algo externo através da url será tratado aqui
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {

        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @GetMapping("/texto/{texto}")
    public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto){
        return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }

//    @DeleteMapping("/{id}")  //o uso desta annotation é muito próximo da annotation GET
//    public void delete(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}