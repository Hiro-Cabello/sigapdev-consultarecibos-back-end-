package edu.moduloalumno.entity;

public class HistorialMatricula {
	
	private String codigoSemestre;
	private Integer planEstudio;
	private String ciclo;
	private String codigoAsignatura;
	private String nombreCurso;
	private String tipoCurso;
	private Integer numeroCreditos;
	
	public String getCodigoSemestre() {
		return codigoSemestre;
	}
	
	public void setCodigoSemestre(String codigoSemestre) {
		this.codigoSemestre = codigoSemestre;
	}
	
	public Integer getPlanEstudio() {
		return planEstudio;
	}
	
	public void setPlanEstudio(Integer planEstudio) {
		this.planEstudio = planEstudio;
	}
	
	public String getCiclo() {
		return ciclo;
	}
	
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	public String getCodigoAsignatura() {
		return codigoAsignatura;
	}
	
	public void setCodigoAsignatura(String codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}
	
	public String getNombreCurso() {
		return nombreCurso;
	}
	
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
	public String getTipoCurso() {
		return tipoCurso;
	}
	
	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	
	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}
	
	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	
}
