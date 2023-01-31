package br.com.imagemfilmes.desafio.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "pedido_item")
public class PedidoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Produto produto;
    private int quantidade;
    @OneToOne
    private Pedido pedido;
}