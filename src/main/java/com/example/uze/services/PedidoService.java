package com.example.uze.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uze.exception.ObjectNotFoundException;
import com.example.uze.model.Pedido;
import com.example.uze.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public void salvar(Pedido pedido) {
		repo.save(pedido);
	}
	
	public void excluir(Pedido pedido) {
		repo.delete(pedido);
	}
	
	public List<Pedido> listar() {
		return repo.findAll();

	}
	
	public void atualizar(Pedido pedido) {
		repo.save(pedido);
	}
	
	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
