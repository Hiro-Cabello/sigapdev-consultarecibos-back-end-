package edu.moduloalumno.entity;

import java.io.Serializable;

public class Presupuesto2 implements Serializable{
	
	private Integer idProgramaPresupuesto;
	private String siglaPrograma;
	private Integer codPlan;
	private String idTipoPresupuesto;
	private Integer nCreditos;
	private String Moneda;
	private double costoMupg;
	private double costoMepg;
	private double costoCiclo;
	private double costoCredito;
	private double costoTotal;
	public Integer getIdProgramaPresupuesto() {
		return idProgramaPresupuesto;
	}
	public void setIdProgramaPresupuesto(Integer idProgramaPresupuesto) {
		this.idProgramaPresupuesto = idProgramaPresupuesto;
	}
	public String getSiglaPrograma() {
		return siglaPrograma;
	}
	public void setSiglaPrograma(String siglaPrograma) {
		this.siglaPrograma = siglaPrograma;
	}
	public Integer getCodPlan() {
		return codPlan;
	}
	public void setCodPlan(Integer codPlan) {
		this.codPlan = codPlan;
	}
	public String getIdTipoPresupuesto() {
		return idTipoPresupuesto;
	}
	public void setIdTipoPresupuesto(String idTipoPresupuesto) {
		this.idTipoPresupuesto = idTipoPresupuesto;
	}
	public Integer getnCreditos() {
		return nCreditos;
	}
	public void setnCreditos(Integer nCreditos) {
		this.nCreditos = nCreditos;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public double getCostoMupg() {
		return costoMupg;
	}
	public void setCostoMupg(double costoMupg) {
		this.costoMupg = costoMupg;
	}
	public double getCostoMepg() {
		return costoMepg;
	}
	public void setCostoMepg(double costoMepg) {
		this.costoMepg = costoMepg;
	}
	public double getCostoCiclo() {
		return costoCiclo;
	}
	public void setCostoCiclo(double costoCiclo) {
		this.costoCiclo = costoCiclo;
	}
	public double getCostoCredito() {
		return costoCredito;
	}
	public void setCostoCredito(double costoCredito) {
		this.costoCredito = costoCredito;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
}
