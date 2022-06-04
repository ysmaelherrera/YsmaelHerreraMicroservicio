package idat.pe.YsmaelHerreraMicroservicio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

	private Integer idClienteRequest;
	private String nombreCliente;
	private String apellidocliente;
	private Integer nroCelular;
	private String direccion;
}
