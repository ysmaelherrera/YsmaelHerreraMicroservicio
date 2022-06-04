package idat.pe.YsmaelHerreraMicroservicio.service;

import java.util.List;

import idat.pe.YsmaelHerreraMicroservicio.dto.RopaRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.RopaResponseDTO;

public interface RopaService {

	public void guardarRopa(RopaRequestDTO r);
	public void eliminaRopa(Integer id);
	public void editarRopa(RopaRequestDTO r);
	public  List<RopaResponseDTO> listarRopa();
	public RopaResponseDTO ropaById(Integer id);
}
