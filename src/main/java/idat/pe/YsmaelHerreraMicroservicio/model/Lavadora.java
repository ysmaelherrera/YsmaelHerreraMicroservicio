package idat.pe.YsmaelHerreraMicroservicio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Table(name = "lavadora")
@Entity
@Getter
@Setter

public class Lavadora {

	private Integer idLavadora;
	private String descripcion;
	private String marca;
	private String voltaje;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "ropa_lavadora",
	joinColumns = @JoinColumn(name = "id_lavadora", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_lavadora) references lavadora (id_lavadora)")),
	inverseJoinColumns = @JoinColumn(name = "id_ropa", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_ropa) references ropa (id_ropa)"))
	)
	private List<Ropa> ropa = new ArrayList<>();
}
