package br.com.imagemfilmes.desafio.entity;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Pessoa {
    @Id
    private long id;
    private String cpf;
    private String nome;

    public Pessoa() {}
    public Pessoa(long id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return getId() == pessoa.getId() && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getNome(), pessoa.getNome());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf(), getNome());
    }
}
