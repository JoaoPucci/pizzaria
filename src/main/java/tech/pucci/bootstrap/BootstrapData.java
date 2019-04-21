package tech.pucci.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tech.pucci.model.Pedido;
import tech.pucci.model.Sabor;
import tech.pucci.model.Tamanho;
import tech.pucci.repository.PedidoRepository;
import tech.pucci.repository.SaborRepository;
import tech.pucci.repository.TamanhoRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	private TamanhoRepository tamanhoRepository;
	private SaborRepository saborRepository;
	private PedidoRepository pedidoRepository;
	
	public BootstrapData(TamanhoRepository tamanhoRepository, SaborRepository saborRepository, PedidoRepository pedidoRepository) {
		this.tamanhoRepository = tamanhoRepository;
		this.saborRepository = saborRepository;
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loading initial data...");
		cadastrarTamanhos();
		cadastrarSabores();	
		System.out.println(pedidoRepository.findAll());
	}
	
	private void cadastrarTamanhos() {
		Tamanho tamanhoPequena = new Tamanho();
		tamanhoPequena.setDescricao("Pequena");
		tamanhoPequena.setTempoPreparo(15);
		tamanhoPequena.setValor(BigDecimal.valueOf(20.0));
		tamanhoRepository.save(tamanhoPequena);
		
		Tamanho tamanhoMedia = new Tamanho();
		tamanhoMedia.setDescricao("Média");
		tamanhoMedia.setTempoPreparo(20);
		tamanhoMedia.setValor(BigDecimal.valueOf(30.0));
		tamanhoRepository.save(tamanhoMedia);
		
		Tamanho tamanhoGrande = new Tamanho();
		tamanhoGrande.setDescricao("Grande");
		tamanhoGrande.setTempoPreparo(25);
		tamanhoGrande.setValor(BigDecimal.valueOf(40.0));
		tamanhoRepository.save(tamanhoGrande);
	}
	
	private void cadastrarSabores() {
		Sabor saborCalabresa = new Sabor();
		saborCalabresa.setDescricao("Calabresa");
		saborCalabresa.setTempoAdicional(0);
		saborRepository.save(saborCalabresa);
	
		Sabor saborMarguerita = new Sabor();
		saborMarguerita.setDescricao("Marguerita");
		saborMarguerita.setTempoAdicional(0);
		saborRepository.save(saborMarguerita);
		
		Sabor saborPortuguesa = new Sabor();
		saborPortuguesa.setDescricao("Portuguesa");
		saborPortuguesa.setTempoAdicional(5);
		saborRepository.save(saborPortuguesa);
	}
	
}
