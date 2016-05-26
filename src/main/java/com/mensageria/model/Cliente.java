package com.mensageria.model;

public class Cliente {
	
	private int id;
	private String email;
	private boolean confirmado;
	private String nome;
	
	public Cliente(int id, String email, boolean confirmado, String nome) {
		super();
		this.email = email;
		this.confirmado = confirmado;
		this.nome = nome;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
