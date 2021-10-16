package com.DigitalHouse.blog.controller;


import com.DigitalHouse.blog.repositoy.UsuarioRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")

public class UsuarioController {

    private UsuarioRepository repository;


}
