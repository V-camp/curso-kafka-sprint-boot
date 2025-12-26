package io.cursokafka.icompras.clientes.controller;

import io.cursokafka.icompras.clientes.model.Clientes;
import io.cursokafka.icompras.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Clientes> salvar(@RequestBody Clientes cliente) {
        service.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Clientes> obterDados(@PathVariable("codigo") Long codigo) {
        return service
                .obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable("codigo") Long codigo) {
        Clientes cliente = service.obterPorCodigo(codigo)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente inexistente"
                ));

        service.deletar(cliente);
        return ResponseEntity.noContent().build();
    }
}
