package idat.pe.YsmaelHerreraMicroservicio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LavadoraRequestDTO {

	private Integer idLavadoraRequest;
	private String descripcion;
	private String marca;
	private String voltaje;
}
