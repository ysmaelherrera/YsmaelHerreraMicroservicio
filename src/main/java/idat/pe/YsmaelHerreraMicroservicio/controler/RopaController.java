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

import idat.pe.YsmaelHerreraMicroservicio.dto.RopaRequestDTO;
import idat.pe.YsmaelHerreraMicroservicio.dto.RopaResponseDTO;
import idat.pe.YsmaelHerreraMicroservicio.service.RopaService;

@RestController
@RequestMapping("/ropa/v1")
public class RopaController {

	@Autowired
	private RopaService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	 public ResponseEntity<List<RopaResponseDTO>>listar(){
		 return new ResponseEntity<List<RopaResponseDTO>>(service.listarRopa(),HttpStatus.OK);
	 }
	 
	 @RequestMapping(method = RequestMethod.POST, path = "/guardar")
	 public ResponseEntity<Void> guardar(@RequestBody RopaRequestDTO ropa) {
		 service.guardarRopa(ropa);
		 return new ResponseEntity<Void>(HttpStatus.CREATED);
	 }
	 
	 
	 @RequestMapping(method = RequestMethod.GET,path = "listar/{id}")
	 public @ResponseBody ResponseEntity<RopaResponseDTO> ropaById(@PathVariable Integer id) {
		 RopaResponseDTO ropa = service.ropaById(id);
		 if(ropa != null){
			return new ResponseEntity<RopaResponseDTO>(HttpStatus.OK); 
		 }
		 return new ResponseEntity<RopaResponseDTO>(HttpStatus.NOT_FOUND);
	 }
	 
	 @RequestMapping(method = RequestMethod.GET,path = "eliminar/{id}")
	 public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		 RopaResponseDTO ropa = service.ropaById(id);
		 if(ropa != null) {
			 service.eliminaRopa(id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	 }
	 
	 
	 
	 public ResponseEntity<Void> editar( @RequestBody RopaRequestDTO ropa) {
		 if(ropa != null) {
			service.editarRopa(ropa);
			return new ResponseEntity<Void>(HttpStatus.OK);
		 }
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	 }
	
	
}
