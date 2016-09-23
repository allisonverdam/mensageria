package com.mensageria.model.domain;

public class Dispositivo {
	
	private int id;
	private String mac;
	private String nome;
	private Cliente proprietario;
	
	public Dispositivo(int id, String mac, String nome, Cliente proprietario) {
		super();
		this.proprietario = proprietario;
		this.id = id;
		this.mac = mac;
		this.nome = nome;
	}
	
	public Cliente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
