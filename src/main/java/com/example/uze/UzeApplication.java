package com.example.uze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.uze.model.Cliente;
import com.example.uze.model.Filial;
import com.example.uze.model.Vendedor;
import com.example.uze.services.ClienteService;
import com.example.uze.services.VendedorService;

@SpringBootApplication
public class UzeApplication implements CommandLineRunner{
	
	@Autowired
	private VendedorService vendedorService;
	
	private ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(UzeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * List<Vendedor> vendedores = new ArrayList<>(); Cliente c1 = new Cliente();
		 * c1.setNome("Guts");
		 * 
		 * Cliente c2 = new Cliente(); c2.setNome("Caska");
		 * 
		 * Filial f1 = new Filial(); f1.setNome("Bando dos falcões");
		 * 
		 * Vendedor v1 = new Vendedor(); v1.setNome("Griffith"); v1.setFilial(f1);
		 * 
		 * vendedores.add(v1);
		 * 
		 * f1.setVendedores(vendedores);
		 * 
		 * vendedorService.salvar(v1); clienteService.salvarTodos(Arrays.asList(c1,
		 * c2));
		 */
	}

}
