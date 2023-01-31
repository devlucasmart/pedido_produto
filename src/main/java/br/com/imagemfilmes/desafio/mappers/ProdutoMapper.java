package br.com.imagemfilmes.desafio.mappers;

import br.com.imagemfilmes.desafio.dtos.ProdutoDto;
import br.com.imagemfilmes.desafio.entities.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    static ProdutoDto toDto(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }
    static Produto toDomain(ProdutoDto produtoDto) {
        // TODO Auto-generated method stub
        return null;
    }

}