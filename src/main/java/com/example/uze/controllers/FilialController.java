package com.example.uze.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uze.model.Filial;
import com.example.uze.model.Vendedor;
import com.example.uze.services.VendedorService;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

	@RequestMapping(method = RequestMethod.GET)
	private List<Filial> listar() {
		List<Filial> filiais = new ArrayList<Filial>();
		return filiais;

	}

}