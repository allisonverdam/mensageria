package com.mensageria.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.domain.Cliente;
import com.mensageria.model.domain.Empresa;
import com.mensageria.model.domain.Mensagem;

@RestController
public class ControllerMensagem {
	ArrayList<Mensagem> listaMensagens = new ArrayList<Mensagem>();
	Cliente c1 = new Cliente(1, "allisonverdam@gmail.com", true,
			"Allison Verdam da Cunha");
	Cliente c2 = new Cliente(2, "teste@gmail.com", true, "Jorge");
	Cliente c3 = new Cliente(3, "fsfsfsf@gmail.com", true, "João");
	Cliente c4 = new Cliente(4, "emailloucasso@gmail.com", true, "Cara");
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	Empresa empresa = new Empresa(1, "email@email.com", "565656565", "Empresa 1");
	Mensagem mensagem1 = new Mensagem(1, "teste", "Mensagem 1", listaClientes, empresa);
	Mensagem mensagem2 = new Mensagem(1, "teste", "Mensagem 2", listaClientes, empresa);

	
	public ControllerMensagem(){

		listaClientes.add(c1);
		listaClientes.add(c2);
		listaClientes.add(c3);
		listaClientes.add(c4);				
		listaMensagens.add(mensagem1);
		
		listaClientes.add(c3);
		listaClientes.add(c1);
		listaClientes.add(c4);				
		listaClientes.add(c2);
		listaMensagens.add(mensagem2);
	}
		@CrossOrigin()
		@RequestMapping(value = "/mensagens", method = RequestMethod.GET)
		public ArrayList<Mensagem> getAllMensagens() {
	
			return listaMensagens;
		}
	
		@CrossOrigin()
		@RequestMapping(value = "/mensagem/{id}", method = RequestMethod.GET)
		public Mensagem getMensagem(@PathVariable("id") int id) {
			return listaMensagens.get(id);
		}
}
