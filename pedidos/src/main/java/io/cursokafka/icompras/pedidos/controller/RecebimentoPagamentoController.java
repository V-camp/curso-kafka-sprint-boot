package io.cursokafka.icompras.pedidos.controller;

import io.cursokafka.icompras.pedidos.controller.dto.RecebimentoCallbackpPagamentoDTO;
import io.cursokafka.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/callback-pagamentos")
@RequiredArgsConstructor
public class RecebimentoPagamentoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusPagamento(
        @RequestBody RecebimentoCallbackpPagamentoDTO body,
        @RequestHeader(required = true, name = "apiKey") String apíKey
    ) {
        pedidoService.atualizarStatusPagamento(
                body.codigo(),
                body.chavePagamento(),
                body.status(),
                body.observacoes()
        );

        return ResponseEntity.ok().build();
    }
}
