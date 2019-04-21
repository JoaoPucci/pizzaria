package tech.pucci.service;

import tech.pucci.model.Pedido;

public interface PedidoService {
	
	Pedido savePedido(Pedido pedido);

	Pedido getResumoPedido(Long id);

}
