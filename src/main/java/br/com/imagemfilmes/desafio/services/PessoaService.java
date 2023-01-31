package br.com.imagemfilmes.desafio.services;

import br.com.imagemfilmes.desafio.dtos.PessoaDto;
import br.com.imagemfilmes.desafio.entities.Pedido;
import br.com.imagemfilmes.desafio.entities.Pessoa;
import br.com.imagemfilmes.desafio.mappers.PessoaMapper;
import br.com.imagemfilmes.desafio.repositories.PessoaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    private static PessoaMapper PessoaMapper = Mappers.getMapper(PessoaMapper.class);

    public List<PessoaDto> buscarTodos() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDto> pessoaDtos = new ArrayList<PessoaDto>();
        for (Pessoa pessoa : pessoas) {
            pessoaDtos.add(PessoaMapper.toDto(pessoa));
        }
        return pessoaDtos;
    }

    public PessoaDto buscarPorId(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return PessoaMapper.toDto(pessoa.get());
    }

    public PessoaDto inserir(PessoaDto pessoaDto) {
        Pessoa pessoa = PessoaMapper.toDomain(pessoaDto);
        pessoa = pessoaRepository.save(pessoa);
        return PessoaMapper.toDto(pessoa);
    }

    public PessoaDto atualizar(Integer id, PessoaDto pessoaDto) {
        pessoaDto.setId(id);
        Pessoa pessoa = PessoaMapper.toDomain(pessoaDto);
        pessoa = pessoaRepository.save(pessoa);
        return PessoaMapper.toDto(pessoa);
    }

    public void deletar(Integer id) {

        pessoaRepository.deleteById(id);
    }


}
