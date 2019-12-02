package com.example.uze.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.uze.model.Cliente;
import com.example.uze.model.Vendedor;
import com.example.uze.services.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;


	@GetMapping("/cadastrar")
	private String cadastrar(Cliente cliente) {
		return "/cliente/cadastro";
	}

	@GetMapping("listar")
	private String listar(ModelMap modelMap) {
		modelMap.addAttribute("clientes", clienteService.listar());
		return "/cliente/lista";
	}

	@PostMapping("/salvar")
	private String salvar(Cliente cliente, RedirectAttributes attr, BindingResult result) {
		clienteService.salvar(cliente);
		attr.addFlashAttribute("success", "Registro cadastrado com sucesso!");
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/editor/{id}")
	private String abrirTelaEditar(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("cliente", clienteService.buscarPorId(id));
		return "/cliente/edicao";
	}

	@PostMapping("/editar")
	private String editar(Cliente cliente, RedirectAttributes attr) {
		clienteService.salvar(cliente);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		Cliente cliente = clienteService.buscarPorId(id);
		clienteService.excluir(cliente);
		attr.addFlashAttribute("success", "Registro excluido com sucesso.");
		return "redirect:/clientes/listar";
	}
	
	


}