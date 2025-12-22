package io.cursokafka.icompras.pedidos.controller.mappers;

import io.cursokafka.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.cursokafka.icompras.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface ItemPedidoMapper {
    ItemPedido map(ItemPedidoDTO dto);
}
