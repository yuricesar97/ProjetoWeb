package br.com.yuri.projetoweb.resource;


import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.services.CategoriaService;
import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}" , method =  RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categoria cat = service.findId(id);
        return ResponseEntity.ok().body(cat);

    }
}
