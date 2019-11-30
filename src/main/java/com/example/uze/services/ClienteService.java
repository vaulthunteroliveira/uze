package com.example.uze.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.uze.model.Cliente;
import com.example.uze.repositories.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repo;
	
	public void salvarTodos(List<Cliente> clientes) {
		repo.saveAll(clientes);
	}
	
}
