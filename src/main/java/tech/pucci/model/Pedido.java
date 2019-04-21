package tech.pucci.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn
	private Tamanho tamanho;
	
	@ManyToOne
	@JoinColumn
	private Sabor sabor;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "pedido_adicional",
    joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "adicional_id", referencedColumnName = "id"))
	private Set<Adicional> adicionais;
	
	@Transient
	private int tempoPreparo = 0;
	
	@Transient
	private BigDecimal valor = BigDecimal.ZERO;
	
	public void calcularValorTotal() {
		BigDecimal valorAdicional = BigDecimal.ZERO;
		
		if (hasAdicionais()) {
			valorAdicional = this.getAdicionais().stream()
					.map((adicional) -> adicional.getValor()).reduce((adicional, valor) -> adicional.add(valor)).get();
		}
		
		this.setValor(this.getTamanho().getValor().add(valorAdicional));
	}
	
	public void calcularTempoPreparo() {
		int tempoAdicional = 0;
		
		if (hasAdicionais()) {
			tempoAdicional = this.getAdicionais().stream().mapToInt(adicional -> adicional.getTempoPreparo()).sum();	
		}
		
		this.setTempoPreparo(this.getTamanho().getTempoPreparo() + this.getSabor().getTempoAdicional() + tempoAdicional);
	}
	
	public boolean hasAdicionais() {
		return !(this.getAdicionais() == null || this.getAdicionais().isEmpty());
	}
	
	public boolean hasAdicionaisRepetidos() {
		for(Adicional adicional : this.getAdicionais()) {
			boolean isRepetido = this.getAdicionais().stream().filter(adicional2 -> adicional2.getId() == adicional.getId()).count() > 1;
			
			if (isRepetido) {
				return true;
			}
		}
		
		return false;
	}

}
