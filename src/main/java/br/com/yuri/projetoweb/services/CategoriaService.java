package br.com.yuri.projetoweb.services;

import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria findId(Integer id){
        Optional<Categoria> op = repo.findById(id);
        return  op.orElse(null);

    }
}
