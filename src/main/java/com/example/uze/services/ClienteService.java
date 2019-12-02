package com.example.uze.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uze.exception.ObjectNotFoundException;
import com.example.uze.model.Cliente;
import com.example.uze.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public void salvar(Cliente cliente) {
		repo.save(cliente);
	}
	
	public void excluir(Cliente cliente) {
		repo.delete(cliente);
	}
	
	public List<Cliente> listar() {
		return repo.findAll();

	}
	
	public void atualizar(Cliente cliente) {
		repo.save(cliente);
	}
	
	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
