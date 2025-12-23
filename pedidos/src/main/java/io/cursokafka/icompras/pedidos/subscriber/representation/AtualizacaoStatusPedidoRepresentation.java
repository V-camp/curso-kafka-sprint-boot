package io.cursokafka.icompras.pedidos.subscriber.representation;

import io.cursokafka.icompras.pedidos.model.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio
) { }
