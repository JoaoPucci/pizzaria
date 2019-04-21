package tech.pucci.bootstrap;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tech.pucci.model.Adicional;
import tech.pucci.model.Sabor;
import tech.pucci.model.Tamanho;
import tech.pucci.repository.AdicionalRepository;
import tech.pucci.repository.PedidoRepository;
import tech.pucci.repository.SaborRepository;
import tech.pucci.repository.TamanhoRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	@Autowired
	private TamanhoRepository tamanhoRepository;
	@Autowired
	private SaborRepository saborRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private AdicionalRepository adicionalRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Carregando dados iniciais...");

		cadastrarTamanhos();
		cadastrarSabores();	
		cadastrarAdicionais();
		
		System.out.println("Carregamento completo");
		
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
	
	private void cadastrarAdicionais() {
		Adicional extraBacon = new Adicional();
		extraBacon.setDescricao("Extra Bacon");
		extraBacon.setTempo(0);
		extraBacon.setValor(BigDecimal.valueOf(3));
		adicionalRepository.save(extraBacon);
		
		Adicional semCebola = new Adicional();
		semCebola.setDescricao("Sem Cebola");
		semCebola.setTempo(0);
		semCebola.setValor(BigDecimal.valueOf(0));
		adicionalRepository.save(semCebola);
		
		Adicional bordaRecheada = new Adicional();
		bordaRecheada.setDescricao("Borda Recheada");
		bordaRecheada.setTempo(5);
		bordaRecheada.setValor(BigDecimal.valueOf(5));
		adicionalRepository.save(bordaRecheada);
	}
	
}
