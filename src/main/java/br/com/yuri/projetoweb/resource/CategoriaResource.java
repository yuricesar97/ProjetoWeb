package br.com.yuri.projetoweb.resource;


import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.dto.CategoriaDTO;
import br.com.yuri.projetoweb.services.CategoriaService;
import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;

        @RequestMapping(value = "/{id}" , method =  RequestMethod.GET)
        public ResponseEntity<Categoria> find(@PathVariable Integer id){
            Categoria cat = service.findId(id);
            return ResponseEntity.ok().body(cat);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll(){
           List<Categoria> list = service.findAll();
           List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.POST ) //RequestBody Faz json ser convertido em obj java
    public ResponseEntity<Void> insert (@RequestBody Categoria obj){
            Categoria cat = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria obj,@PathVariable Integer id){
            obj.setId(id);
            obj = service.update(obj);
            return ResponseEntity.noContent().build();
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
          service.delete(id);
          return  ResponseEntity.noContent().build();
    }
}
