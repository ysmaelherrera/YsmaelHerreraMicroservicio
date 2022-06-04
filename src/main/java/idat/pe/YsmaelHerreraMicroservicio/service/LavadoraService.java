package idat.pe.YsmaelHerreraMicroservicio.service;

import java.util.List;

import idat.pe.YsmaelHerreraMicroservicio.dto.LavadoraRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.LavadoraResponseDTO;



public interface LavadoraService {

	public void guardarLavadora(LavadoraRequestDTO l);
	public void eliminaLavadora(Integer id);
	public void editarLavadora(LavadoraRequestDTO l);
	public  List<LavadoraResponseDTO> listarLavadora();
	public LavadoraResponseDTO lavadoraById(Integer id);
}
