package br.com.yuri.projetoweb.repositories;

import br.com.yuri.projetoweb.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ItemPedidoRepository  extends JpaRepository<ItemPedido, Integer> {
}
