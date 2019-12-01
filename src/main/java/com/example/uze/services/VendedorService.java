package com.example.uze.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uze.model.Vendedor;
import com.example.uze.repositories.ClienteRepository;
import com.example.uze.repositories.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repo;
	
	private void salvar(Vendedor vendedor) {
		repo.save(vendedor);
	}
	
	private void excluir(Vendedor vendedor) {
		repo.delete(vendedor);
	}
	
	private List<Vendedor> listar() {
		return repo.findAll();

	}
	
	private void atualizar(Vendedor vendedor) {
		repo.save(vendedor);
	}
	
}
