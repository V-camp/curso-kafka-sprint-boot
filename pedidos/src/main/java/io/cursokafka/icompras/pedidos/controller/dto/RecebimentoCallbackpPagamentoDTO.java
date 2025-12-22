package io.cursokafka.icompras.pedidos.controller.dto;

public record RecebimentoCallbackpPagamentoDTO(
        Long codigo,
        String chavePagamento,
        boolean status,
        String observacoes
) { }
