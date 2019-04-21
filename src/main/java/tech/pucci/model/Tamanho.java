package tech.pucci.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
public class Tamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private int tempoPreparo;
	
	public Tamanho() {}
	
	public Tamanho(String descricao, BigDecimal valor, int tempoPreparo) {
		this.descricao = descricao;
		this.valor = valor;
		this.tempoPreparo = tempoPreparo;
	}
	
	public Tamanho(String descricao, Double valor, int tempoPreparo) {
		this.descricao = descricao;
		this.valor = BigDecimal.valueOf(valor);
		this.tempoPreparo = tempoPreparo;
	}

}