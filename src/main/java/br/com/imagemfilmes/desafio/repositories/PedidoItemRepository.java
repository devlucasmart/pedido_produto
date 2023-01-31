package br.com.imagemfilmes.desafio.repositories;

import br.com.imagemfilmes.desafio.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}
