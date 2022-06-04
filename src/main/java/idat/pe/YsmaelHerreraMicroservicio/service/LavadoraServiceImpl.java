package idat.pe.YsmaelHerreraMicroservicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.pe.YsmaelHerreraMicroservicio.dto.LavadoraRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.LavadoraResponseDTO;
import idat.pe.YsmaelHerreraMicroservicio.model.Lavadora;
import idat.pe.YsmaelHerreraMicroservicio.repository.LavadoraRepository;

@Service
public class LavadoraServiceImpl implements LavadoraService {

	@Autowired
	private LavadoraRepository repository;
	
	@Override
	public void guardarLavadora(LavadoraRequestDTO l) {
		// TODO Auto-generated method stub

		Lavadora lavadora = new Lavadora();
		lavadora.setIdLavadora(l.getIdLavadoraRequest());
		lavadora.setDescripcion(l.getDescripcion());
		lavadora.setMarca(l.getMarca());
		lavadora.setVoltaje(l.getVoltaje());
		repository.save(lavadora);
	}

	@Override
	public void eliminaLavadora(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarLavadora(LavadoraRequestDTO l) {
		// TODO Auto-generated method stub

		Lavadora lavadora = new Lavadora();
		lavadora.setIdLavadora(l.getIdLavadoraRequest());
		lavadora.setDescripcion(l.getDescripcion());
		lavadora.setMarca(l.getMarca());
		lavadora.setVoltaje(l.getVoltaje());
		repository.saveAndFlush(lavadora);
	}

	@Override
	public List<LavadoraResponseDTO> listarLavadora() {
		// TODO Auto-generated method stub
		
		List<Lavadora> lavadora = repository.findAll();
		List<LavadoraResponseDTO> dto = new ArrayList<LavadoraResponseDTO>();
		LavadoraResponseDTO lavadoraDTO = null;
		
		for (Lavadora lavadoras: lavadora) {
			lavadoraDTO.setIdLavadoraResponse(lavadoras.getIdLavadora());
			lavadoraDTO.setDescripcion(lavadoras.getDescripcion());
			lavadoraDTO.setMarca(lavadoras.getDescripcion());
			lavadoraDTO.setVoltaje(lavadoras.getVoltaje());
			dto.add(lavadoraDTO);
		}
		
		
		return dto;
	}

	@Override
	public LavadoraResponseDTO lavadoraById(Integer id) {
		// TODO Auto-generated method stub
		
		Lavadora lavadora = repository.findById(id).orElse(null);
		LavadoraResponseDTO lavadoraDTO = new LavadoraResponseDTO();
		
		lavadoraDTO.setIdLavadoraResponse(lavadora.getIdLavadora());
		lavadoraDTO.setDescripcion(lavadora.getDescripcion());
		lavadoraDTO.setMarca(lavadora.getDescripcion());
		lavadoraDTO.setVoltaje(lavadora.getVoltaje());
		
		return lavadoraDTO;
	}

}
