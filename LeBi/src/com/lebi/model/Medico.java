package com.lebi.model;

public class Medico extends Usuario{

	private String especialidade;
	private String crm;
	
	public Medico(String nome, String email) {
		super(nome, email);
	}
	
	public Medico() {}
	
	public String getEspecialidade() {return especialidade;}
	public void setEspecialidade(String especialidade) {this.especialidade = especialidade;}
	
	public String getCrm() {return crm;}
	public void setCrm(String crm) {this.crm = crm;}
	

}
