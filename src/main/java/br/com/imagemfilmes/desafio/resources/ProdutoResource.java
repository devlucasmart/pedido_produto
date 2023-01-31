package br.com.imagemfilmes.desafio.resources;

import br.com.imagemfilmes.desafio.dtos.ProdutoDto;
import br.com.imagemfilmes.desafio.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> buscarTodos() {
        return ResponseEntity.ok().body(produtoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(produtoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody ProdutoDto produtoDto) {
        produtoDto = produtoService.inserir(produtoDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produtoDto.getId()).toUri();
        HttpHeaders header = new HttpHeaders();
        header.add("id", produtoDto.getId().toString());

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody ProdutoDto produtoDto) {
        produtoService.atualizar(id, produtoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
