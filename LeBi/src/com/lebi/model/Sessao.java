package com.lebi.model;

public class Sessao {
	
	private static Sessao uniqueInstance;
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Sessao() {}

	public static synchronized Sessao getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Sessao();

		return uniqueInstance;
	}
}
