package com.lebi.model;


import com.lebi.dao.UsuarioDao;

public class Usuario {
	protected int id;
	protected String nome;
	protected String email;
	protected String telefone;
	protected String senha;
	protected String endereco;
	
	public Usuario(){}
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(String nome, String telefone, String endereco, String senha, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;}
	
	public String getEndereco() {return endereco;}
	public void setEndereco(String endereco) {this.endereco = endereco;}
	
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	UsuarioDao ud = new UsuarioDao();
	
	public Usuario login() {
				
		Usuario user = ud.login(email, senha);
		
		if(user != null) {
			this.nome = user.getNome();
			return user;
		}
		return null;
	}
	
	public boolean cadastro() {
			return false;	
	}
	



}
