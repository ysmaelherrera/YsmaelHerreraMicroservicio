package idat.pe.YsmaelHerreraMicroservicio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDTO {
	
	private Integer idClienteResponse;
	private String nombreCliente;
	private String apellidocliente;
	private Integer nroCelular;
	private String direccion;
}
