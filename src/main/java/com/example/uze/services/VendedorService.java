package com.example.uze.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uze.exception.ObjectNotFoundException;
import com.example.uze.model.Vendedor;
import com.example.uze.repositories.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repo;
	
	public void salvar(Vendedor vendedor) {
		repo.save(vendedor);
	}
	
	public void excluir(Vendedor vendedor) {
		repo.delete(vendedor);
	}
	
	public List<Vendedor> listar() {
		return repo.findAll();

	}
	
	public void atualizar(Vendedor vendedor) {
		repo.save(vendedor);
	}

	public Vendedor buscarPorId(Integer id) {
		Optional<Vendedor> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Vendedor.class.getName()));
	}
	
}
