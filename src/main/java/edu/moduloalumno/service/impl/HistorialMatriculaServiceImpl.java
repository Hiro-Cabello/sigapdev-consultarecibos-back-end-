package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IHistorialMatriculaDAO;
import edu.moduloalumno.entity.HistorialMatricula;
import edu.moduloalumno.service.IHistorialMatriculaService;

@Service
public class HistorialMatriculaServiceImpl implements IHistorialMatriculaService{

	@Autowired
	private IHistorialMatriculaDAO historialMatriculaDAO;
	
	@Override
	public List<HistorialMatricula> getHistorialMatricula(String codigo) {
		
		List<HistorialMatricula> historialMatriculasList = historialMatriculaDAO.getHistorialMatriculas(codigo);
		
		return historialMatriculasList;
	
	}

}
