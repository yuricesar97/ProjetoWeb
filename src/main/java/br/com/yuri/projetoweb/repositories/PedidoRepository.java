package br.com.yuri.projetoweb.repositories;

import br.com.yuri.projetoweb.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer > {
}
