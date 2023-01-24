package br.com.imagemfilmes.desafio.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;
import java.util.Objects;

public class Pedido {
    @Id
    private Long id;
    private Pessoa pessoa;
    private List<PedidoItem> itens;

    public Pedido() {

    }
    public Pedido(Long id, Pessoa pessoa) {
        this.id = id;
        this.pessoa = pessoa;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<PedidoItem> getItens() {

        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(getId(), pedido.getId()) && Objects.equals(getPessoa(), pedido.getPessoa()) && Objects.equals(getItens(), pedido.getItens());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPessoa(), getItens());
    }
}
