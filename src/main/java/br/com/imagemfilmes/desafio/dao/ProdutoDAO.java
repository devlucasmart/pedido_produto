package br.com.imagemfilmes.desafio.dao;

import br.com.imagemfilmes.desafio.entity.Pessoa;
import br.com.imagemfilmes.desafio.entity.Produto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDAO extends DAO{
    public ProdutoDAO(final Connection connection) {
        super(connection);
    }

    public List<Produto> findAll() throws SQLException {
        try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM produto")) {
            try (ResultSet rs = psmt.executeQuery()) {
                final List<Produto> produtos = new ArrayList<>();
                while (rs.next()) {
                    final Produto produto = new Produto();

                    produtos.add(produto);
                }
                return produtos;
            }
        }
    }
}
