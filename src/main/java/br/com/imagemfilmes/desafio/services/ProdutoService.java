package br.com.imagemfilmes.desafio.services;

import br.com.imagemfilmes.desafio.dtos.PessoaDto;
import br.com.imagemfilmes.desafio.dtos.ProdutoDto;
import br.com.imagemfilmes.desafio.entities.Pessoa;
import br.com.imagemfilmes.desafio.entities.Produto;
import br.com.imagemfilmes.desafio.mappers.PessoaMapper;
import br.com.imagemfilmes.desafio.mappers.ProdutoMapper;
import br.com.imagemfilmes.desafio.repositories.ProdutoRepository;
import org.apache.logging.log4j.message.Message;
import org.aspectj.bridge.IMessage;
import org.hibernate.ObjectNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    private static ProdutoMapper produtoMapper = Mappers.getMapper(ProdutoMapper.class);

    public List<ProdutoDto> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDto> produtoDtos = new ArrayList<ProdutoDto>();
        for (Produto produto : produtos) {
            produtoDtos.add(ProdutoMapper.toDto(produto));
        }
        return produtoDtos;
    }

    public ProdutoDto buscarPorId(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return ProdutoMapper.toDto(produto.get());
    }
    public ProdutoDto inserir(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.toDomain(produtoDto);
        produto = produtoRepository.save(produto);
        return ProdutoMapper.toDto(produto);
    }

    public ProdutoDto atualizar(Integer id, ProdutoDto produtoDto) {
        produtoDto.setId(id);
        Produto produto = ProdutoMapper.toDomain(produtoDto);
        produto = produtoRepository.save(produto);
        return ProdutoMapper.toDto(produto);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }




}
