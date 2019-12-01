package com.example.uze.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.uze.model.Pedido;
import com.example.uze.repositories.ClienteRepository;
import com.example.uze.repositories.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository repo;
	
	private void salvar(Pedido pedido) {
		repo.save(pedido);
	}
	
	private void excluir(Pedido pedido) {
		repo.delete(pedido);
	}
	
	private List<Pedido> listar() {
		return repo.findAll();

	}
	
	private void atualizar(Pedido pedido) {
		repo.save(pedido);
	}
	
}
