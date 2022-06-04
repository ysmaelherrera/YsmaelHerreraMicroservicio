package idat.pe.YsmaelHerreraMicroservicio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "cliente")
@Entity
@Getter
@Setter
public class Cliente {

	private Integer idCliente;
	private String nombreCliente;
	private String apellidocliente;
	private Integer nroCelular;
	private String direccion;
	
	@ManyToMany(mappedBy = "ropa", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Ropa> ropa = new ArrayList<>();
}
