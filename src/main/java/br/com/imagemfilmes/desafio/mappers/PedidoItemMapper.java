package br.com.imagemfilmes.desafio.mappers;

import br.com.imagemfilmes.desafio.dtos.PedidoItemDto;
import br.com.imagemfilmes.desafio.entities.PedidoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoItemMapper {

   PedidoItemDto toDto(PedidoItem pedidoItem);
   PedidoItem toDomain(PedidoItemDto pedidoItemDto);

   @Mapping(target = "pedido", ignore = true)
   @Mapping(target = "produto", ignore = true)
   PedidoItemDto toDtoIgnorePedidoItem(PedidoItem pedidoItem );
}
