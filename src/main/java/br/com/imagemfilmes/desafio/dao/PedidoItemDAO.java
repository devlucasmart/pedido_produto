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
public class PedidoItemDAO extends DAO{
    public PedidoItemDAO(final Connection connection) {
        super(connection);
    }
    public List<PedidoItem> findAll() throws SQLException {
        try (PreparedStatement psmt = getConnection().prepareStatement("SELECT * FROM pedidoitem")) {
            try (ResultSet rs = psmt.executeQuery()) {
                final List<PedidoItem> pedidoitens = new ArrayList<>();
                while (rs.next()) {
                    final PedidoItem pedidoitem = new PedidoItem();

                    pedidoitens.add(pedidoitem);
                }
                return pedidoitens;
            }
        }
    }
}
