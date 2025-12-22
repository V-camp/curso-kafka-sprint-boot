package io.cursokafka.icompras.pedidos.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public record NovoPedidoDTO(
        Long codigoCliente,
        DadosPagamentoDTO dadosPagamento,
        List<ItemPedidoDTO> itens
) { }
