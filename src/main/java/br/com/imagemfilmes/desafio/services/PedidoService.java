package br.com.imagemfilmes.desafio.services;

import br.com.imagemfilmes.desafio.dtos.PedidoDto;
import br.com.imagemfilmes.desafio.entities.Pedido;
import br.com.imagemfilmes.desafio.mappers.PedidoMapper;
import br.com.imagemfilmes.desafio.repositories.PedidoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    private static PedidoMapper PedidoMapper = Mappers.getMapper(PedidoMapper.class);

    public List<PedidoDto> buscarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDto> pedidoDtos = new ArrayList<PedidoDto>();
        for (Pedido pedido : pedidos) {
            pedidoDtos.add(PedidoMapper.toDto(pedido));
        }
        return pedidoDtos;
    }

    public PedidoDto buscarPorId(Integer id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return PedidoMapper.toDto(pedido.get());
    }

    public PedidoDto inserir(PedidoDto pedidoDto) {
        Pedido pedido = PedidoMapper.toDomain(pedidoDto);
        pedido = pedidoRepository.save(pedido);
        return PedidoMapper.toDto(pedido);
    }

    public PedidoDto atualizar(Integer id, PedidoDto pedidoDto) {
        pedidoDto.setId(id);
        Pedido pedido = PedidoMapper.toDomain(pedidoDto);
        pedido = pedidoRepository.save(pedido);
        return PedidoMapper.toDto(pedido);
    }

    public void deletar(Integer id) {

        pedidoRepository.deleteById(id);
    }


}
