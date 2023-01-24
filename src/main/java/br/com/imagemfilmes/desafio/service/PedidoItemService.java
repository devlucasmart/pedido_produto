package br.com.imagemfilmes.desafio.service;

import br.com.imagemfilmes.desafio.dao.PedidoItemDAO;
import br.com.imagemfilmes.desafio.dao.PessoaDAO;
import br.com.imagemfilmes.desafio.entity.PedidoItem;
import br.com.imagemfilmes.desafio.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Service
public class PedidoItemService {
    @Autowired
    DataSource dataSource;

    public List<PedidoItem> getPedidoItem() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            return new PedidoItemDAO(connection).findAll();
        }
    }
}
