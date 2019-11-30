package com.example.uze.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uze.model.Vendedor;
import com.example.uze.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedoController {
	
	@Autowired
	private VendedorService service;
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	private ResponseEntity<?> findById(@PathVariable Integer id) {
		Vendedor vendedor = service.buscarPorId(id);
		return ResponseEntity.ok().body(vendedor);
	}

}
