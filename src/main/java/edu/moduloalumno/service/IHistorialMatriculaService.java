package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.HistorialMatricula;

public interface IHistorialMatriculaService {

	List<HistorialMatricula> getHistorialMatricula(String codigo);
	
}
