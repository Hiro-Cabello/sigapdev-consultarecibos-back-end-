package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.HistorialMatricula;

public class HistorialMatriculaRowMapper implements RowMapper<HistorialMatricula> {

	@Override
	public HistorialMatricula mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		HistorialMatricula historialMatricula = new HistorialMatricula();
		
		historialMatricula.setCodigoSemestre(rs.getString("cod_semestre"));
		historialMatricula.setPlanEstudio(rs.getInt("cod_plan"));
		historialMatricula.setCiclo(rs.getString("numciclo"));
		historialMatricula.setCodigoAsignatura(rs.getString("cod_asignatura"));
		historialMatricula.setNombreCurso(rs.getString("nom_curso"));
		historialMatricula.setTipoCurso(rs.getString("tipocurso"));
		historialMatricula.setNumeroCreditos(rs.getInt("numcreditaje"));
		
		return historialMatricula;
		
	}

}
