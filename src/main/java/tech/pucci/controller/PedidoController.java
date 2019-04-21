package tech.pucci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tech.pucci.model.Pedido;
import tech.pucci.service.PedidoService;

@RestController
@RequestMapping(PedidoController.BASE_URL)
public class PedidoController {
	
	public static final String BASE_URL = "/api/v1/pedidos"; 
	
	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/{id}")
	public Pedido getResumoPedido(@PathVariable Long id) {
		return pedidoService.getResumoPedido(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido savePedido(@RequestBody Pedido pedido) {
		return pedidoService.savePedido(pedido);
	}

}
