package idat.pe.YsmaelHerreraMicroservicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.pe.YsmaelHerreraMicroservicio.dto.ClienteRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.ClienteResponseDTO;
import idat.pe.YsmaelHerreraMicroservicio.model.Cliente;
import idat.pe.YsmaelHerreraMicroservicio.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteRequestDTO c) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setIdCliente(c.getIdClienteRequest());
		cliente.setNombreCliente(c.getNombreCliente());
		cliente.setApellidocliente(c.getApellidocliente());
		cliente.setNroCelular(c.getNroCelular());
		cliente.setDireccion(c.getDireccion());
		repository.save(cliente);

	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub

		repository.deleteById(id);
	}

	@Override
	public void editarCliente(ClienteRequestDTO c) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setIdCliente(c.getIdClienteRequest());
		cliente.setNombreCliente(c.getNombreCliente());
		cliente.setApellidocliente(c.getApellidocliente());
		cliente.setNroCelular(c.getNroCelular());
		cliente.setDireccion(c.getDireccion());
		repository.saveAndFlush(cliente);

	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		// TODO Auto-generated method stub
		List<Cliente> cliente = repository.findAll();
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDTO = null;
		
		for (Cliente clientes: cliente) {
			clienteDTO = new ClienteResponseDTO();
			clienteDTO.setIdClienteResponse(clientes.getIdCliente());
			clienteDTO.setNombreCliente(clientes.getNombreCliente());
			clienteDTO.setApellidocliente(clientes.getApellidocliente());
			clienteDTO.setNroCelular(clientes.getNroCelular());
			clienteDTO.setDireccion(clientes.getDireccion());
			dto.add(clienteDTO);
		}
		
		return dto;
		
		
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteResponseDTO clienteDTO = new ClienteResponseDTO();
		
		clienteDTO = new ClienteResponseDTO();
		clienteDTO.setIdClienteResponse(cliente.getIdCliente());
		clienteDTO.setNombreCliente(cliente.getNombreCliente());
		clienteDTO.setApellidocliente(cliente.getApellidocliente());
		clienteDTO.setNroCelular(cliente.getNroCelular());
		clienteDTO.setDireccion(cliente.getDireccion());
		
		return clienteDTO;
	}

}
