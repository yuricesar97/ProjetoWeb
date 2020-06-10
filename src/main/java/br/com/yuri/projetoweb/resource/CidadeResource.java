package br.com.yuri.projetoweb.resource;

import br.com.yuri.projetoweb.domain.Cidade;
import br.com.yuri.projetoweb.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeResource {

    @Autowired
    private CidadeService service;

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Cidade> buscaId(@PathVariable Integer id){
        Cidade city = service.findId(id);
        return ResponseEntity.ok().body(city);

    }
}
