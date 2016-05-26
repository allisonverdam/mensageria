package com.mensageria.model;

public class Empresa {
	
	private int id;
	private String contato;
	private String cnpj;
	private String nome;

	public Empresa(int id, String contato, String cnpj, String nome) {
		super();
		this.id		 = id;
		this.contato = contato;
		this.cnpj    = cnpj;
		this.nome    = nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
