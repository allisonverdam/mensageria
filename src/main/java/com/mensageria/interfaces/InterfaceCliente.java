package com.mensageria.interfaces;

import com.mensageria.model.Cliente;
import com.mensageria.model.Mensagem;

public interface InterfaceCliente {
	
	void ConfirmarMensagem(Cliente cliente);
	
	Mensagem ReceberMensagem(Cliente cliente);
	
	boolean TemMensagem(Cliente cliente);

}
