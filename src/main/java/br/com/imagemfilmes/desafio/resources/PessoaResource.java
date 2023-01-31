package br.com.imagemfilmes.desafio.resources;

import br.com.imagemfilmes.desafio.dtos.PessoaDto;
import br.com.imagemfilmes.desafio.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDto>> buscarTodos() {
        return ResponseEntity.ok().body(pessoaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pessoaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody PessoaDto pessoaDto) {
        pessoaDto = pessoaService.inserir(pessoaDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaDto.getId()).toUri();
        HttpHeaders header = new HttpHeaders();
        header.add("id", pessoaDto.getId().toString());

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody PessoaDto pessoaDto) {
        pessoaService.atualizar(id, pessoaDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
