package idat.pe.YsmaelHerreraMicroservicio.service;

import java.util.List;

import idat.pe.YsmaelHerreraMicroservicio.dto.ClienteRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.ClienteResponseDTO;

public interface ClienteService {

	public void guardarCliente(ClienteRequestDTO c);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClienteRequestDTO c);
	public  List<ClienteResponseDTO> listarCliente();
	public ClienteResponseDTO clienteById(Integer id);
}
