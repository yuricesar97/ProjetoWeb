package br.com.yuri.projetoweb.services;


import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.domain.Estado;
import br.com.yuri.projetoweb.repositories.EstadoRepository;
import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public Estado findId(Integer id){
        Optional<Estado> op = repo.findById(id);
        return op.orElseThrow(() -> new ObjectException("Objeto não encontrado! id: " +
                id + ", Tipo:" + Categoria.class.getName()));
    }

}
