package com.DigitalHouse.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
public class PostController {

        @GetMapping
        public String Post() {
            return "Vai dar certo, confia!!(?)";
        }

}
