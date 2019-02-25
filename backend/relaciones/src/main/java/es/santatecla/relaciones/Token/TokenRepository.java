package es.santatecla.relaciones.Token;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TokenRepository extends CrudRepository<Token, Long>{

    /*
    Token findByName(String name);
    */
    Token findById(long id);
    List<Token> findAll();

}