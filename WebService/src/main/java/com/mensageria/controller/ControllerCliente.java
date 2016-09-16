package com.mensageria.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mensageria.model.dao.ClienteDao;
import com.mensageria.model.domain.Cliente;

@RestController
public class ControllerCliente {
	
	@Autowired
	private ClienteDao clienteDao;

	Cliente c1 = new Cliente(1, "allisonverdam@gmail.com", true,
			"Allison Verdam da Cunha");
	Cliente c2 = new Cliente(2, "teste@gmail.com", true, "Jorge");
	Cliente c3 = new Cliente(3, "fsfsfsf@gmail.com", true, "João");
	Cliente c4 = new Cliente(4, "emailloucasso@gmail.com", true, "Cara");
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public ControllerCliente() {
		super();
		listaClientes.add(c1);
		listaClientes.add(c2);
		listaClientes.add(c3);
		listaClientes.add(c4);
	}

	@CrossOrigin()
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public ArrayList<Cliente> getAllUsuarios() {

		return listaClientes;
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public Cliente getUsuario(@PathVariable("id") int id) {

		return listaClientes.get(id);
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/criarCliente", method = RequestMethod.GET)
	public String criarUsuarios(){
		try {
			Cliente cliente = new Cliente("teste@teste.com", false, "Teste");
			clienteDao.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return "deu ruim\n" + e.toString();
		}	
		return "sucesso";
	}

}
