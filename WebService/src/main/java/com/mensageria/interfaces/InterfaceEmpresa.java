package com.mensageria.interfaces;

import java.util.ArrayList;

import com.mensageria.model.domain.Cliente;
import com.mensageria.model.domain.Mensagem;
import com.mensageria.model.domain.Token;

public interface InterfaceEmpresa {

	Token EnviarMensagem(ArrayList<Cliente> listaIDs, Mensagem mensagem);

	ArrayList<Cliente> VerificarLidos(Token token);

	ArrayList<Cliente> VerificarNaoLidos(Token token);

	ArrayList<Cliente> VerificarNaoRecebidos(Token token);
	
	ArrayList<Cliente> getClientes();

}
