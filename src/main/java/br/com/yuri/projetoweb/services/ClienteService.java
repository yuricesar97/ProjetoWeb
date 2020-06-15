package br.com.yuri.projetoweb.services;


import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.domain.Cliente;
import br.com.yuri.projetoweb.repositories.ClienteRepository;
import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscaId(Integer id){
        Optional<Cliente> cli = repo.findById(id);
        return  cli.orElseThrow(() -> new ObjectException("Objeto não encontrado! id: " +
                id + ", Tipo:" + Categoria.class.getName()));
    }

}
