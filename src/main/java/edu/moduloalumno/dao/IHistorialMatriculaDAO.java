package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.HistorialMatricula;

public interface IHistorialMatriculaDAO {

	List<HistorialMatricula> getHistorialMatriculas(String codigo);
	
}
