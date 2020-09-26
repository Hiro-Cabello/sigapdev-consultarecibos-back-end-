package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.HistorialMatricula;
import edu.moduloalumno.service.IHistorialMatriculaService;

@CrossOrigin
@RestController
@RequestMapping("/matricula")
public class HistorialMatriculaController {

	@Autowired
	private IHistorialMatriculaService historialMatriculaService;
	
	@RequestMapping(value = "/listar-historial/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialMatricula>> getHistorialMatricual(@PathVariable("codigo") String codigo){
		
		List<HistorialMatricula> listHistorialMatriculas = null;
		
		try {
			listHistorialMatriculas = historialMatriculaService.getHistorialMatricula(codigo);
			
			if(listHistorialMatriculas == null) {
				listHistorialMatriculas = new ArrayList<HistorialMatricula>();
			}
		} catch (Exception e) {
			return new ResponseEntity<List<HistorialMatricula>>(listHistorialMatriculas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<HistorialMatricula>>(listHistorialMatriculas, HttpStatus.OK);
		
	}
	
}
