package com.mensageria.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private boolean confirmado;
	private String nome;

	public Cliente(int id){
		this.id = id;
	};
	
	public Cliente(String email, boolean confirmado, String nome){
		this.email = email;
		this.confirmado = confirmado;
		this.nome = nome;
	}
	
	public Cliente(){}
	
	
	
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
