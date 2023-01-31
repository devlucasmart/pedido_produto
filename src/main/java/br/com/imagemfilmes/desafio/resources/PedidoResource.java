package br.com.imagemfilmes.desafio.resources;

import br.com.imagemfilmes.desafio.dtos.PedidoDto;
import br.com.imagemfilmes.desafio.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> buscarTodos() {
        return ResponseEntity.ok().body(pedidoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pedidoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody PedidoDto pedidoDto) {
        pedidoDto = pedidoService.inserir(pedidoDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedidoDto.getId()).toUri();
        HttpHeaders header = new HttpHeaders();
        header.add("id", pedidoDto.getId().toString());

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody PedidoDto pedidoDto) {
        pedidoService.atualizar(id, pedidoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}