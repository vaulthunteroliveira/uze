package com.example.uze.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.uze.model.Filial;
import com.example.uze.model.Vendedor;
import com.example.uze.services.FilialService;
import com.example.uze.services.VendedorService;

@Controller
@RequestMapping(value = "/filiais")
public class FilialController {

	@Autowired
	private FilialService service;

	@GetMapping("/cadastrar")
	private String cadastrar(Filial filial) {
		return "/filial/cadastro";
	}

	@GetMapping("/listar")
	private String listar() {
		return "/filial/lista";
	}

	@PostMapping("/salvar")
	private String salvar(Filial filial, RedirectAttributes attr, BindingResult result) {
		service.salvar(filial);
		attr.addFlashAttribute("success", "filial cadastrada com sucesso!");
		return "redirect:/filias/cadastrar";
	}

}