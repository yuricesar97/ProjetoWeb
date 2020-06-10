package br.com.yuri.projetoweb.repositories;

import br.com.yuri.projetoweb.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
