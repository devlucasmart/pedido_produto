package br.com.imagemfilmes.desafio.dao;

import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.entity.PedidoItem;
import br.com.imagemfilmes.desafio.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoDAO extends DAO{
    public PedidoDAO(final Connection connection) {
        super(connection);
    }
    public List<Pedido> findAll() throws SQLException {
        try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM pedido")) {
            try (ResultSet rs = psmt.executeQuery()) {
                final List<Pedido> pedidos = new ArrayList<>();
                while (rs.next()) {
                    final Pedido pedido = new Pedido();

                    pedidos.add(pedido);
                }
                return pedidos;
            }
        }
    }
}
