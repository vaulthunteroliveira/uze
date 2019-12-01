package com.example.uze.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uze.model.Cliente;
import com.example.uze.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	private void salvar(Cliente cliente) {
		repo.save(cliente);
	}
	
	private void excluir(Cliente cliente) {
		repo.delete(cliente);
	}
	
	private List<Cliente> listar() {
		return repo.findAll();

	}
	
	private void atualizar(Cliente cliente) {
		repo.save(cliente);
	}
	
}
