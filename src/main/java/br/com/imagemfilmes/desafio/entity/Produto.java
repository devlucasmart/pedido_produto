package br.com.imagemfilmes.desafio.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    @Id
    private int registro;
    private String descricao;
    private BigDecimal valorUnitario;

    public Produto() {

    }
    public Produto(int registro, String descricao) {
        this.registro = registro;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {

        this.registro = registro;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public BigDecimal getValorUnitario() {

        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {

        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "registro=" + registro +
                ", descricao='" + descricao + '\'' +
                ", valorUnitario=" + valorUnitario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getRegistro() == produto.getRegistro() && Objects.equals(getDescricao(), produto.getDescricao()) && Objects.equals(getValorUnitario(), produto.getValorUnitario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistro(), getDescricao(), getValorUnitario());
    }
}
