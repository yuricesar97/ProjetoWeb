package br.com.yuri.projetoweb.resource;


import br.com.yuri.projetoweb.domain.Estado;
import br.com.yuri.projetoweb.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

        @Autowired
        private EstadoService service;

        @RequestMapping(value = "/{id}")
        public ResponseEntity<Estado> findId(@PathVariable  Integer id){
            Estado est = service.findId(id);
            return ResponseEntity.ok().body(est);

        }

}
