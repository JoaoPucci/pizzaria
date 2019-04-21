package tech.pucci.model;

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
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_adicional",
    joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "adicional_id", referencedColumnName = "id"))
	private Set<Adicional> adicionais;

}
