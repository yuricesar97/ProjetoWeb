package br.com.yuri.projetoweb.resource;


import br.com.yuri.projetoweb.domain.Cliente;
import br.com.yuri.projetoweb.services.ClienteService;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

   @Autowired
   private ClienteService repo;

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public ResponseEntity<Cliente> buscaId(@PathVariable Integer id){
        Cliente cli = repo.buscaId(id);
        return ResponseEntity.ok().body(cli);
    }

}
