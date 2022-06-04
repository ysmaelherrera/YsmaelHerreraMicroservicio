package idat.pe.YsmaelHerreraMicroservicio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "ropa")
@Entity
@Getter
@Setter

public class Ropa {

	private Integer idRopa;
	private String tipoRopa;
	private String descripcion;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "cliente_ropa",
	joinColumns = @JoinColumn(name = "id_hospital", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_ropa) references ropa (id_ropa)")),
	inverseJoinColumns = @JoinColumn(name = "id_cliente", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references cliente (id_cliente)"))
	)
	private List<Cliente> cliente = new ArrayList<>();
	
	@ManyToMany(mappedBy = "lavadora", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Lavadora> lavadora = new ArrayList<>();
}
