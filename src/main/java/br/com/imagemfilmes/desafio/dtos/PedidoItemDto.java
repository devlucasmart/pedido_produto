package br.com.imagemfilmes.desafio.dtos;

import br.com.imagemfilmes.desafio.entities.Pedido;
import br.com.imagemfilmes.desafio.entities.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class PedidoItemDto {
    private Integer id;
    private Produto produto;
    private int quantidade;
    private Pedido pedido;
}
