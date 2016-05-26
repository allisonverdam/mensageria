package com.mensageria.interfaces;

import java.util.ArrayList;

import com.mensageria.model.Cliente;
import com.mensageria.model.Mensagem;
import com.mensageria.model.Token;

public interface InterfaceEmpresa {

	Token EnviarMensagem(ArrayList<Cliente> listaIDs, Mensagem mensagem);

	ArrayList<Cliente> VerificarLidos(Token token);

	ArrayList<Cliente> VerificarNaoLidos(Token token);

	ArrayList<Cliente> VerificarNaoRecebidos(Token token);
	
	ArrayList<Cliente> getClientes();

}
