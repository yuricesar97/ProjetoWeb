package br.com.yuri.projetoweb.repositories;

import br.com.yuri.projetoweb.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
}
