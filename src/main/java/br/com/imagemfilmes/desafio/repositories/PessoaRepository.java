package br.com.imagemfilmes.desafio.repositories;

import br.com.imagemfilmes.desafio.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
