package com.example.uze.services;

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

	public Vendedor buscarPorId(Integer id) {
		/*
		 * if (repo.findById(id) == null) { throw new ObjectNotFoundException(
		 * "Objeto não encontrado! id: " + id + ", tipo:" + Vendedor.class.getName()); }
		 */
		return repo.findById(id).orElse(null);

	}

	public void salvar(Vendedor v1) {
		repo.save(v1);

	}
}
