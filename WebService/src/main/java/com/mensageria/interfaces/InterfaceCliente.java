package com.mensageria.interfaces;

import com.mensageria.model.domain.Cliente;
import com.mensageria.model.domain.Mensagem;

public interface InterfaceCliente {
	
	void ConfirmarMensagem(Cliente cliente);
	
	Mensagem ReceberMensagem(Cliente cliente);
	
	boolean TemMensagem(Cliente cliente);

}
