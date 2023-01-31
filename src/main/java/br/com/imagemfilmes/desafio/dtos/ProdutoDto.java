package br.com.imagemfilmes.desafio.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class ProdutoDto {
    private Integer id;
    private String descricao;
    private BigDecimal valorUnitario;
}
