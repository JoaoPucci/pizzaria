package tech.pucci.service;

import org.springframework.stereotype.Service;

import tech.pucci.model.Pedido;
import tech.pucci.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	private PedidoRepository pedidoRepository;
	
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public Pedido savePedido(Pedido pedido) {
		if (pedido.getTamanho() == null || pedido.getSabor() == null) {
			throw new RuntimeException("Não é possível incluir meia pizza");
		}
		
		if (pedido.hasAdicionaisRepetidos()) {
			throw new RuntimeException("Não é possível incluir adicionais repetidos");
		}
	
		
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido getResumoPedido(Long id) {
		Pedido pedido = pedidoRepository.findById(id).orElse(new Pedido());

		if (pedido.getId() > 0) {
			pedido.calcularTempoPreparo();
			pedido.calcularValorTotal();	
		}
		
		return pedido;
	}

}
