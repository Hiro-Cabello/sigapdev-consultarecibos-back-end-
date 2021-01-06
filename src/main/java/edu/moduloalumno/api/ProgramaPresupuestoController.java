package edu.moduloalumno.api;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.ProgramaPresupuesto;
import edu.moduloalumno.service.IProgramaPresupuestoService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/programa_presupuesto")
public class ProgramaPresupuestoController {

	@Autowired
	private IProgramaPresupuestoService programaPresupuestoService;
	
	
	@GetMapping("/listar/{codigo}")
	private List<ProgramaPresupuesto> listarProgramaPresupuesto(@PathVariable String codigo){
		return programaPresupuestoService.listarPrograma(codigo);
	}
	
	@RequestMapping(value = "/listartodo/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProgramaPresupuesto>> listarProgPresAll(@PathVariable("codigo") Integer codigo) {
		
		List<ProgramaPresupuesto> programaPresupuesto = null;
		try {
			programaPresupuesto = programaPresupuestoService.listarProgramaPresupuesto(codigo);

			if (programaPresupuesto == null) {	
				programaPresupuesto = new ArrayList<ProgramaPresupuesto>();
			}
			
		} catch (Exception e) {
			return new ResponseEntity<List<ProgramaPresupuesto>>(programaPresupuesto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<ProgramaPresupuesto>>(programaPresupuesto, HttpStatus.OK);
		
	}
	
}
