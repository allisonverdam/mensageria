package com.mensageria.controller;

import java.util.ArrayList;

import com.mensageria.interfaces.InterfaceEmpresa;
import com.mensageria.model.Cliente;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Token;

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
