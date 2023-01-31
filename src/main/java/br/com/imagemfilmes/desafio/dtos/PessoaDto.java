package br.com.imagemfilmes.desafio.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class PessoaDto {
    private Integer id;
    private String cpf;
    private String nome;
}
