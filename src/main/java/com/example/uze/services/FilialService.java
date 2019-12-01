package com.example.uze.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uze.exception.ObjectNotFoundException;
import com.example.uze.model.Filial;
import com.example.uze.repositories.FilialRepository;

@Service
public class FilialService {

	@Autowired
	private FilialRepository repo;
	
	public void salvar(Filial filial) {
		repo.save(filial);
	}
	
	public void excluir(Filial filial) {
		repo.delete(filial);
	}
	
	public List<Filial> listar() {
		return repo.findAll();

	}
	
	public void atualizar(Filial filial) {
		repo.save(filial);
	}

	public Filial buscarPorId(Integer id) {
		Optional<Filial> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Filial.class.getName()));
	}
	
}
