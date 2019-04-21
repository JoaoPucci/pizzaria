package tech.pucci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
public class Sabor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descricao;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private int tempoAdicional;
	
	public Sabor() {}
	
	public Sabor(String descricao) {
		this.descricao = descricao;
		tempoAdicional = 0;
	}
}