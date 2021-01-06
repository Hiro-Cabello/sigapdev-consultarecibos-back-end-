package edu.moduloalumno.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IProgramaPresupuestoDao;
import edu.moduloalumno.entity.Presupuesto2;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.ProgramaPresupuesto;
import edu.moduloalumno.rowmapper.Presupuesto2RowMapper;
import edu.moduloalumno.rowmapper.ProgramaPresupuestoRowMapper;
import edu.moduloalumno.rowmapper.ProgramaRowMapper;

@Transactional
@Repository
public class ProgramaPresupuestoDaoImpl implements IProgramaPresupuestoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ProgramaPresupuesto> listarPrograma(String codigo) {
		
		/**String sql="select CONCAT('Ciclo ', ppd.id_programa_ciclo) as ciclo,c.concepto,c.descripcion_min, mon.moneda, ppd.importe from alumno_programa ap  " + 
				"	inner join programa_presupuesto pp on ap.id_programa_presupuesto=pp.id_programa_presupuesto  " + 
				"	inner join programa_presupuesto_det ppd on ap.id_programa_presupuesto=ppd.id_programa_presupuesto " + 
				"	inner join concepto c on ppd.id_concepto=c.id_concepto " + 
				"	inner join moneda mon on pp.id_moneda=mon.id_moneda where ap.cod_alumno='"+ codigo +"'" + 
				"order by 1,2;";**/
		
		String sql = "select CONCAT('Ciclo ', pc.ciclo) as ciclo,c.concepto,c.descripcion_min, mon.moneda, ppd.importe " + 
				"from alumno_programa ap " + 
				"inner join programa_presupuesto pp on ap.id_programa_presupuesto=pp.id_programa_presupuesto " + 
				"inner join programa_presupuesto_det ppd on ap.id_programa_presupuesto=ppd.id_programa_presupuesto " + 
				"inner join concepto c on (ppd.id_concepto=c.id_concepto) " + 
				"inner join moneda mon on (pp.id_moneda=mon.id_moneda) " + 
				"inner join programa p on (ap.id_programa=p.id_programa) " + 
				"inner join programa_ciclo pc on (pc.id_programa_ciclo=ppd.id_programa_ciclo " + 
				"and pc.id_tip_grado=p.id_tip_grado) " + 
				"where ap.cod_alumno='"+ codigo + "'" + 
				"and ap.id_programa=(select id_programa from alumno_programa where cod_alumno = ap.cod_alumno) " + 
				"order by 1,2;";
		
		RowMapper<ProgramaPresupuesto> rowMapper = new ProgramaPresupuestoRowMapper();
		List<ProgramaPresupuesto> programaPresupuesto=this.jdbcTemplate.query(sql, rowMapper);
		
		return programaPresupuesto;
	}
	
	/*@Override
	public List<ProgramaPresupuesto> listarProgramaPresupuesto(Integer codigo) {
		
		try {
			String sql = "select CONCAT('Ciclo ', pc.ciclo) as ciclo,c.concepto,c.descripcion_min, mon.moneda, ppd.importe, c.id_concepto "
					+ "from programa_presupuesto pp "
					+ "inner join programa_presupuesto_det ppd on pp.id_programa_presupuesto = ppd.id_programa_presupuesto "
					+ "inner join concepto c on (ppd.id_concepto=c.id_concepto) "
					+ "inner join moneda mon on (pp.id_moneda=mon.id_moneda) "
					+ "inner join programa p on (pp.id_programa=p.id_programa) "
					+ "inner join programa_ciclo pc on (pc.id_programa_ciclo=ppd.id_programa_ciclo "
					+ "and pc.id_tip_grado=p.id_tip_grado) "
					+ "where pp.id_programa_presupuesto = '40' "
					+ "order by 1,2;";
			
			RowMapper<ProgramaPresupuesto> rowMapper = new ProgramaPresupuestoRowMapper();
			List<ProgramaPresupuesto> programaPresupuesto = jdbcTemplate.query(sql, rowMapper);
			
			return programaPresupuesto;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}*/
	
	@Override
	public List<ProgramaPresupuesto> listarProgramaPresupuesto(Integer codigo) {
		
		String sql = "select CONCAT('Ciclo ', pc.ciclo) as ciclo,c.concepto,c.descripcion_min, mon.moneda, ppd.importe, c.id_concepto "
				+ "from programa_presupuesto pp "
				+ "inner join programa_presupuesto_det ppd on pp.id_programa_presupuesto = ppd.id_programa_presupuesto "
				+ "inner join concepto c on (ppd.id_concepto=c.id_concepto) "
				+ "inner join moneda mon on (pp.id_moneda=mon.id_moneda) "
				+ "inner join programa p on (pp.id_programa=p.id_programa) "
				+ "inner join programa_ciclo pc on (pc.id_programa_ciclo=ppd.id_programa_ciclo "
				+ "and pc.id_tip_grado=p.id_tip_grado) "
				+ "where pp.id_programa_presupuesto=? "
				+ "order by 1,2;";
		RowMapper<ProgramaPresupuesto> rowMapper = new ProgramaPresupuestoRowMapper();
		List<ProgramaPresupuesto> presupuesto = this.jdbcTemplate.query(sql, rowMapper, codigo);
		return presupuesto;		
	}

}
