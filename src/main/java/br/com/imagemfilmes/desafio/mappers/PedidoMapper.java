package br.com.imagemfilmes.desafio.mappers;

import br.com.imagemfilmes.desafio.dtos.PedidoDto;
import br.com.imagemfilmes.desafio.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDto toDto(Pedido pedido);
    Pedido toDomain(PedidoDto pedidoDto);

    @Mapping(target = "pessoa", ignore = true)
    @Mapping(target = "itens", ignore = true)
    PedidoDto toDtoIgnorePedido(Pedido pedido);
}