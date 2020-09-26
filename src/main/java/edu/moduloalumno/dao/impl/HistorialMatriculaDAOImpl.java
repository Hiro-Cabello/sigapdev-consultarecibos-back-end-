package edu.moduloalumno.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IHistorialMatriculaDAO;
import edu.moduloalumno.entity.HistorialMatricula;
import edu.moduloalumno.rowmapper.HistorialMatriculaRowMapper;

@Transactional
@Repository
public class HistorialMatriculaDAOImpl implements IHistorialMatriculaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<HistorialMatricula> getHistorialMatriculas(String codigo) {

		//String sql = "select m.cod_semestre, c.planestudios, m.num_ciclo, m.cod_asignatura, c.nom_curso, c.tipocurso, c.numcreditaje "
		//		+ "from alumno_programa ap, matricula_hist m, curso c " + "where ap.cod_alumno = m.cod_alumno "
		//		+ "and m.cod_asignatura = c.cod_asignatura " + "and ap.cod_alumno = ?";
		
		String sql = "select m.cod_semestre, m.cod_plan, c.numciclo, " + 
				"c.cod_asignatura, c.nom_curso, c.tipocurso, c.numcreditaje " + 
				"from alumno_programa ap, matricula_hist m, curso c " + 
				"where ap.cod_alumno = m.cod_alumno " + 
				"and m.cod_asignatura = c.cod_asignatura " + 
				"and m.cod_plan = cast(c.planestudios as integer) " + 
				"and ap.cod_alumno = ? " + 
				"order by m.cod_semestre, m.cod_plan, c.numciclo, c.cod_asignatura";
		
		RowMapper<HistorialMatricula> rowMapper = new HistorialMatriculaRowMapper();
		
		return this.jdbcTemplate.query(sql, rowMapper, codigo);
		
	}

}
