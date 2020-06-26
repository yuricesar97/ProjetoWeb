package br.com.yuri.projetoweb.resource;

import br.com.yuri.projetoweb.domain.Pedido;
import br.com.yuri.projetoweb.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> findId(@PathVariable Integer id){
        Pedido pedido = pedidoService.findId(id);
        return ResponseEntity.ok().body(pedido);

    }


}
