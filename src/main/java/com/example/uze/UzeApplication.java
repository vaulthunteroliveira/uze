package com.example.uze;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UzeApplication implements CommandLineRunner{
	

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
