package io.cursokafka.icompras.pedidos.service;

import io.cursokafka.icompras.pedidos.model.enums.StatusPedido;
import io.cursokafka.icompras.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository repository;

    @Transactional
    public void atualizarStatus(
            Long codigo,
            StatusPedido status,
            String urlNotaFiscal,
            String rastreio
    ) {
        repository.findById(codigo).ifPresent(pedido -> {
            pedido.setStatus(status);
            pedido.setUrlNotaFiscal(urlNotaFiscal);
            pedido.setCodigoRastreio(rastreio);
        });
    }
}
