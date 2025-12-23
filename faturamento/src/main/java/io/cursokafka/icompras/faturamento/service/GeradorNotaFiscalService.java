package io.cursokafka.icompras.faturamento.service;

import io.cursokafka.icompras.faturamento.bucket.BucketFile;
import io.cursokafka.icompras.faturamento.bucket.BucketService;
import io.cursokafka.icompras.faturamento.model.Pedido;
import io.cursokafka.icompras.faturamento.publisher.FaturamentoPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeradorNotaFiscalService {

    private final NotaFiscalService notaFiscalService;
    private final BucketService bucketService;
    private final FaturamentoPublisher faturamentoPublisher;

    public void gerar(Pedido pedido) {
        log.info("Gerada nota fiscal para o pedido {}", pedido.codigo());

        try {
            byte[] byteArray = notaFiscalService.gerarNota(pedido);

            String nomeArquivo = String.format("notafiscal_pedido_%d.pdf", pedido.codigo());

            var file = new BucketFile(
                    nomeArquivo,
                    new ByteArrayInputStream(byteArray),
                    MediaType.APPLICATION_PDF,
                    byteArray.length
            );

            bucketService.upload(file);

            String url = bucketService.getUrl(nomeArquivo);
            faturamentoPublisher.publicar(pedido, url);

            log.info("Gerada a nota fiscal, nome do arquivo: {}", nomeArquivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
}
