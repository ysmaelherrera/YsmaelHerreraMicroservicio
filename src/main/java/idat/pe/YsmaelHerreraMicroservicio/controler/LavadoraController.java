package idat.pe.YsmaelHerreraMicroservicio.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import idat.pe.YsmaelHerreraMicroservicio.dto.LavadoraRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.LavadoraResponseDTO;
import idat.pe.YsmaelHerreraMicroservicio.service.LavadoraService;

@RestController
@RequestMapping("/lavadora/v1")
public class LavadoraController {
	
	@Autowired
	private LavadoraService service;

	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	 public ResponseEntity<List<LavadoraResponseDTO>>listar(){
		 return new ResponseEntity<List<LavadoraResponseDTO>>(service.listarLavadora(),HttpStatus.OK);
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, path = "/guardar")
	 public ResponseEntity<Void> guardar(@RequestBody LavadoraRequestDTO lavadora) {
		 service.guardarLavadora(lavadora);
		 return new ResponseEntity<Void>(HttpStatus.CREATED);
	 }
	 
	 
	 @RequestMapping(method = RequestMethod.GET,path = "listar/{id}")
	 public @ResponseBody ResponseEntity<LavadoraResponseDTO> lavadoraById(@PathVariable Integer id) {
		 LavadoraResponseDTO lavadora = service.lavadoraById(id);
		 if(lavadora != null){
			return new ResponseEntity<LavadoraResponseDTO>(HttpStatus.OK); 
		 }
		 return new ResponseEntity<LavadoraResponseDTO>(HttpStatus.NOT_FOUND);
	 }
	 
	 @RequestMapping(method = RequestMethod.GET,path = "eliminar/{id}")
	 public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		 LavadoraResponseDTO lavadora = service.lavadoraById(id);
		 if(lavadora != null) {
			 service.eliminaLavadora(id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	 }
	 
	 
	 
	 public ResponseEntity<Void> editar( @RequestBody LavadoraRequestDTO lavadora) {
		 if(lavadora != null) {
			service.editarLavadora(lavadora);
			return new ResponseEntity<Void>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	 }
}
