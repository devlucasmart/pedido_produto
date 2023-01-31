package br.com.imagemfilmes.desafio.dtos;

import br.com.imagemfilmes.desafio.entities.PedidoItem;
import br.com.imagemfilmes.desafio.entities.Pessoa;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class PedidoDto {

    private Integer id;
    private Pessoa pessoa;
    private List<PedidoItem> itens;
}