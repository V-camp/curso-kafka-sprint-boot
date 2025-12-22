package io.cursokafka.icompras.pedidos.controller.dto;

import io.cursokafka.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
        Long codigoPedido, String dados, TipoPagamento tipoPagamento
) { }
