package com.DigitalHouse.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "tb_tema")
public class Tema {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 40)
    private String descricao;

    @OneToMany (mappedBy = "tema", cascade = CascadeType.ALL)  //Integridade do banco
    @JsonIgnoreProperties("tema")
    private List<Postagem> postagem;

    /* Cardinalidade da Postagem: muitas postagens para 1 tema
    Cardinalidade do Tema: 1 tema para muitas postagens
    Declarando dos dois lados, fecha essa relação.*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
}
