package br.com.imagemfilmes.desafio.resources;

import br.com.imagemfilmes.desafio.dtos.PedidoItemDto;
import br.com.imagemfilmes.desafio.services.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidoitem")
public class PedidoItemResource {

    @Autowired
    private PedidoItemService pedidoItemService;

    @GetMapping
    public ResponseEntity<List<PedidoItemDto>> buscarTodos() {
        return ResponseEntity.ok().body(pedidoItemService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoItemDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pedidoItemService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody PedidoItemDto pedidoItemDto) {
        pedidoItemDto = pedidoItemService.inserir(pedidoItemDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedidoItemDto.getId()).toUri();
        HttpHeaders header = new HttpHeaders();
        header.add("id", pedidoItemDto.getId().toString());

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody PedidoItemDto pedidoItemDto) {
        pedidoItemService.atualizar(id, pedidoItemDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        pedidoItemService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
