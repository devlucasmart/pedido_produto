package br.com.imagemfilmes.desafio.repositories;

import br.com.imagemfilmes.desafio.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
