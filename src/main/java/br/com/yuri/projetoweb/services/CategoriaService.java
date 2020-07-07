package br.com.yuri.projetoweb.services;

import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.repositories.CategoriaRepository;
import br.com.yuri.projetoweb.services.exception.DataIntegrityException;
import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Categoria> findAll(){
        return repo.findAll();

    }

    public Categoria insert(Categoria categoria){
        categoria.setId(null); //Id valendo nulo ele insere
       return repo.save(categoria);
    }
    public Categoria update(Categoria categoria){
        findId(categoria.getId()); //vejo se existe o id
        return repo.save(categoria); //Id valendo nulo atualiza
    }
    public void delete(Integer id){
        findId(id);
        try {
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que tem produtos");
        }
    }
}
