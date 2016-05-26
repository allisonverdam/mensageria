package com.mensageria.model;

import java.util.ArrayList;

public class Mensagem {

	private int id;
	private String conteudo;
	private ArrayList<Cliente> clientes;
	private Empresa remetente;

	public Mensagem(int id, String conteudo, ArrayList<Cliente> clientes,
			Empresa remetente) {
		super();
		this.id        = id;
		this.conteudo  = conteudo;
		this.clientes  = clientes;
		this.remetente = remetente;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Empresa getRemetente() {
		return remetente;
	}

	public void setRemetente(Empresa remetente) {
		this.remetente = remetente;
	}

}
