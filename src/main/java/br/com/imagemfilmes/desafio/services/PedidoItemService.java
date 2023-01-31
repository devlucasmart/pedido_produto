package br.com.imagemfilmes.desafio.services;

import br.com.imagemfilmes.desafio.dtos.PedidoItemDto;
import br.com.imagemfilmes.desafio.entities.PedidoItem;
import br.com.imagemfilmes.desafio.mappers.PedidoItemMapper;
import br.com.imagemfilmes.desafio.repositories.PedidoItemRepository;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoItemService {
    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    private static PedidoItemMapper PedidoItemMapper = Mappers.getMapper(PedidoItemMapper.class);

    public List<PedidoItemDto> buscarTodos() {
        List<PedidoItem> pedido_itens = pedidoItemRepository.findAll();
        List<PedidoItemDto> pedidoItemDtos = new ArrayList<PedidoItemDto>();
        for (PedidoItem pedidoItem : pedido_itens) {
            pedidoItemDtos.add(PedidoItemMapper.toDto(pedidoItem));
        }
        return pedidoItemDtos;
    }

    public PedidoItemDto buscarPorId(Integer id) {
        Optional<PedidoItem> pedidoItem = pedidoItemRepository.findById(id);
        return PedidoItemMapper.toDto(pedidoItem.get());
    }

    public PedidoItemDto inserir(PedidoItemDto pedidoItemDto) {
        PedidoItem pedidoItem = PedidoItemMapper.toDomain(pedidoItemDto);
        pedidoItem = pedidoItemRepository.save(pedidoItem);
        return PedidoItemMapper.toDto(pedidoItem);
    }

    public PedidoItemDto atualizar(Integer id, PedidoItemDto pedidoItemDto) {
        pedidoItemDto.setId(id);
        PedidoItem pedidoItem = PedidoItemMapper.toDomain(pedidoItemDto);
        pedidoItem = pedidoItemRepository.save(pedidoItem);
        return PedidoItemMapper.toDto(pedidoItem);
    }

    public void deletar(Integer id) {
        pedidoItemRepository.deleteById(id);
    }

}