package io.cursokafka.icompras.produtos.controller;

import io.cursokafka.icompras.produtos.model.Produto;
import io.cursokafka.icompras.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        service.salvar(produto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Produto> obterDados(@PathVariable("codigo") Long codigo) {
        return service.obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> obterTodos() {
         List<Produto> produtos = service.obterTodos();
         return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable("codigo") Long codigo) {
        Produto produto = service.obterPorCodigo(codigo)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto inexistente"
                ));

        service.deletar(produto);
        return ResponseEntity.noContent().build();
    }
}
