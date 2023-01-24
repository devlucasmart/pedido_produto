package br.com.imagemfilmes.desafio.dao;

import br.com.imagemfilmes.desafio.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaDAO extends DAO {
    public PessoaDAO(final Connection connection) {
        super(connection);
    }
    public List<Pessoa> findAll() throws SQLException {
        try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM pessoa")) {
            try (ResultSet rs = psmt.executeQuery()) {
                final List<Pessoa> pessoas = new ArrayList<>();
                while (rs.next()) {
                    final Pessoa pessoa = new Pessoa();
                    pessoa.setId(rs.getInt("id"));
                    pessoa.setNome(rs.getString("name"));
                    pessoa.setCpf(rs.getString("cpf"));
                    pessoas.add(pessoa);
                }
                return pessoas;
            }
        }
    }
}
