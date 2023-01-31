package br.com.imagemfilmes.desafio.mappers;

import br.com.imagemfilmes.desafio.dtos.PessoaDto;
import br.com.imagemfilmes.desafio.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaDto toDto(Pessoa pessoa);

    Pessoa toDomain(PessoaDto pessoaDto);
}