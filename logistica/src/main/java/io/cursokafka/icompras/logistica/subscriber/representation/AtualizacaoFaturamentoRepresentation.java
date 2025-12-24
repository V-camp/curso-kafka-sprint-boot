package io.cursokafka.icompras.logistica.subscriber.representation;

import io.cursokafka.icompras.logistica.model.StatusPedido;

public record AtualizacaoFaturamentoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal
) { }
