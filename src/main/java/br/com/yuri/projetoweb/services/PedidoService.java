package br.com.yuri.projetoweb.services;


import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.domain.Pedido;
import br.com.yuri.projetoweb.repositories.PedidoRepository;
import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido findId(Integer id){
        Optional<Pedido> op = repo.findById(id);
        return op.orElseThrow(() -> new ObjectException("Objeto não encontrado! id: " +
                id + ", Tipo:" + Pedido.class.getName()));

    }
}


