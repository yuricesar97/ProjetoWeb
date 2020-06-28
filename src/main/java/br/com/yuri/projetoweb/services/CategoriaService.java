package br.com.yuri.projetoweb.services;

import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.repositories.CategoriaRepository;
import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria findId(Integer id){
        Optional<Categoria> op = repo.findById(id);
        return op.orElseThrow(() -> new ObjectException("Objeto não encontrado! id: " +
                id + ", Tipo:" + Categoria.class.getName()));
    }

    public Categoria insert(Categoria categoria){
        categoria.setId(null);
       return repo.save(categoria);
    }
}
