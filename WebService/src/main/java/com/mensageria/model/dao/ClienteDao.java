package com.mensageria.model.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.mensageria.model.domain.Cliente;

@Transactional
public interface ClienteDao extends CrudRepository<Cliente, Integer>{
}
