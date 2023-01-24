package br.com.imagemfilmes.desafio.controller;

import br.com.imagemfilmes.desafio.entity.Pessoa;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

    @RequestMapping("/listar")
    public List<Void> listar() throws Exception {
        return Collections.emptyList();  //TODO IMPLEMENTAR
    }
    @RequestMapping("/listar/{idCliente}")
    public List<Void> listarByCliente(@PathVariable("idCliente") long idCliente) throws Exception {
        return Collections.emptyList();  //TODO IMPLEMENTAR
    }
    @RequestMapping("/listar/total")
    public List<Pessoa> listarOrdenadoPorValorTotal() throws Exception {
        return Collections.emptyList(); //TODO IMPLEMENTAR
    }

}
