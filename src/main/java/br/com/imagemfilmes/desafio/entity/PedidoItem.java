package br.com.imagemfilmes.desafio.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.annotation.processing.Generated;
import java.util.Objects;

public class PedidoItem {

    @Id
    private long id;
    private Produto produto;
    private int quantidade;
    private Pedido pedido;

    public PedidoItem() {

    }
    public PedidoItem(long id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Produto getProduto() {

        return produto;
    }

    public void setProduto(Produto produto) {

        this.produto = produto;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {

        return pedido;
    }

    public void setPedido(Pedido pedido) {

        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "PedidoItem{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", pedido=" + pedido +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoItem that)) return false;
        return getId() == that.getId() && getQuantidade() == that.getQuantidade() && Objects.equals(getProduto(), that.getProduto()) && Objects.equals(getPedido(), that.getPedido());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduto(), getQuantidade(), getPedido());
    }
}
