package br.com.yuri.projetoweb.services;


import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.domain.Cidade;
import br.com.yuri.projetoweb.repositories.CidadeRepository;
import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    public Cidade findId(Integer id){
        Optional<Cidade> op = repo.findById(id);
        return op.orElseThrow(() -> new ObjectException("Objeto não encontrado! id: " +
                id + ", Tipo:" + Categoria.class.getName()));
    }
}
