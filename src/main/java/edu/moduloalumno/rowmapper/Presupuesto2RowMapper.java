package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Presupuesto2;

public class Presupuesto2RowMapper implements RowMapper<Presupuesto2> {
	@Override
	public Presupuesto2 mapRow(ResultSet row, int rowNum) throws SQLException {
		Presupuesto2 presupuesto = new Presupuesto2();
		presupuesto.setIdProgramaPresupuesto(row.getInt("id_programa_presupuesto"));
		presupuesto.setSiglaPrograma(row.getString("sigla_programa"));
		presupuesto.setCodPlan(row.getInt("cod_plan"));
		presupuesto.setIdTipoPresupuesto(row.getString("id_tipo_presupuesto"));
		presupuesto.setnCreditos(row.getInt("n_creditos"));
		presupuesto.setMoneda(row.getString("moneda"));
		presupuesto.setCostoMupg(row.getDouble("costo_mupg"));
		presupuesto.setCostoMepg(row.getDouble("costo_mepg"));
		presupuesto.setCostoCiclo(row.getDouble("costo_ciclo"));
		presupuesto.setCostoCredito(row.getDouble("costo_credito"));
		presupuesto.setCostoTotal(row.getDouble("costo_total"));
		return presupuesto;
	}
}