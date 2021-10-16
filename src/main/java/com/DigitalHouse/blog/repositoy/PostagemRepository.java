package com.DigitalHouse.blog.repositoy;

import com.DigitalHouse.blog.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    //Consulta por título
    public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
    public List<Postagem> findAllByTextoContainingIgnoreCase (String texto);
}
