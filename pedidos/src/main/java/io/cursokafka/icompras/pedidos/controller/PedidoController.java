package io.cursokafka.icompras.pedidos.controller;

import io.cursokafka.icompras.pedidos.controller.dto.AdicaoNovoPagamentoDTO;
import io.cursokafka.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.cursokafka.icompras.pedidos.controller.mappers.PedidoMapper;
import io.cursokafka.icompras.pedidos.model.ErroResposta;
import io.cursokafka.icompras.pedidos.model.Pedido;
import io.cursokafka.icompras.pedidos.model.exception.ItemNaoEncontradoException;
import io.cursokafka.icompras.pedidos.model.exception.ValidationException;
import io.cursokafka.icompras.pedidos.publisher.DetalhePedidoMapper;
import io.cursokafka.icompras.pedidos.publisher.representation.DetalhePedidoRepresentation;
import io.cursokafka.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;
    private final DetalhePedidoMapper detalhePedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        try {
            var pedido = mapper.map(dto);
            Pedido novoPedido = service.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido.getCodigo());
        } catch (ValidationException e) {
            var erro = new ErroResposta("Erro validação", e.getField(), e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("pagamentos")
    public ResponseEntity<Object> adicionarNovoPagamento(@RequestBody AdicaoNovoPagamentoDTO dto) {
        try {
            service.adicionarNovoPagamento(
                    dto.codigoPedido(), dto.dados(), dto.tipoPagamento()
            );

            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            var erro = new ErroResposta("Item não encontrado", "codigoPedido", e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @GetMapping("{codigo}")
    public ResponseEntity<DetalhePedidoRepresentation> obterDetalhesPedido(@PathVariable Long codigo) {
        return service
                .carregarDadosCompletosPedido(codigo)
                .map(detalhePedidoMapper::map)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
