package idat.pe.YsmaelHerreraMicroservicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.pe.YsmaelHerreraMicroservicio.dto.RopaRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.RopaResponseDTO;
import idat.pe.YsmaelHerreraMicroservicio.model.Ropa;
import idat.pe.YsmaelHerreraMicroservicio.repository.RopaRepository;

@Service
public class RopaServiceImpl implements RopaService {

	@Autowired
	private RopaRepository repository;
	
	@Override
	public void guardarRopa(RopaRequestDTO r) {
		// TODO Auto-generated method stub

		Ropa ropa = new Ropa();
		ropa.setIdRopa(r.getIdRopaRequest());
		ropa.setTipoRopa(r.getTipoRopa());
		ropa.setDescripcion(r.getDescripcion());
		repository.save(ropa);
	}

	@Override
	public void eliminaRopa(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarRopa(RopaRequestDTO r) {
		// TODO Auto-generated method stub

		Ropa ropa = new Ropa();
		ropa.setIdRopa(r.getIdRopaRequest());
		ropa.setTipoRopa(r.getTipoRopa());
		ropa.setDescripcion(r.getDescripcion());
		repository.saveAndFlush(ropa);
	}

	@Override
	public List<RopaResponseDTO> listarRopa() {
		// TODO Auto-generated method stub
		
		List<Ropa> ropa = repository.findAll();
		List<RopaResponseDTO> dto = new ArrayList<RopaResponseDTO>();
		RopaResponseDTO ropaDTO = null;
		
		for(Ropa ropas: ropa) {
			ropaDTO = new RopaResponseDTO();
			ropaDTO.setIdRopaResponse(ropas.getIdRopa());
			ropaDTO.setTipoRopa(ropas.getTipoRopa());
			ropaDTO.setDescripcion(ropas.getDescripcion());
			dto.add(ropaDTO);
		}
				
		return dto;
	}

	@Override
	public RopaResponseDTO ropaById(Integer id) {
		// TODO Auto-generated method stub
		
		Ropa ropa = repository.findById(id).orElse(null);
		RopaResponseDTO ropaDTO = new RopaResponseDTO();
		
		ropaDTO = new RopaResponseDTO();
		ropaDTO.setIdRopaResponse(ropa.getIdRopa());
		ropaDTO.setTipoRopa(ropa.getTipoRopa());
		ropaDTO.setDescripcion(ropa.getDescripcion());
		
		return ropaDTO;
	}

}
