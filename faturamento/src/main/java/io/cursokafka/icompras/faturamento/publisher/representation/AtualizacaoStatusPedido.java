package io.cursokafka.icompras.faturamento.publisher.representation;

public record AtualizacaoStatusPedido(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal
) { }
