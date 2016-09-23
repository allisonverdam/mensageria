package com.mensageria.controller;

import java.util.ArrayList;

import com.mensageria.interfaces.InterfaceEmpresa;
import com.mensageria.model.domain.Cliente;
import com.mensageria.model.domain.Mensagem;
import com.mensageria.model.domain.Token;

public class ControllerEmpresa implements InterfaceEmpresa{

	@Override
	public Token EnviarMensagem(ArrayList<Cliente> listaIDs, Mensagem mensagem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> VerificarLidos(Token token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> VerificarNaoLidos(Token token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> VerificarNaoRecebidos(Token token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

}
