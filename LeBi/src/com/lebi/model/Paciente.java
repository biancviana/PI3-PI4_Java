package com.lebi.model;

import com.lebi.dao.UsuarioDao;

public class Paciente extends Usuario{
	private String cpf;
	private String senha;

	
	
	public Paciente(String nome, String email) {
		super(nome, email);
	}
	
	public Paciente(String nome, String cpf, String telefone, String endereco, String senha, String email) {
		nome = super.getNome();
		this.cpf = cpf;
		telefone = super.getTelefone();
		endereco = super.getEndereco();
		this.senha = senha;
		email = super.getEmail();
	}
	
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}
		
	public boolean cadastro() {
		UsuarioDao ud = new UsuarioDao();
		Boolean paciente = ud.cadastrar(getNome(), getCpf(), getTelefone(), getEndereco(), getSenha(), getEmail());
		
		if(paciente) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
