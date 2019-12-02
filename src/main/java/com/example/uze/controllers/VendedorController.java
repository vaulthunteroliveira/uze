package com.example.uze.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.uze.model.Filial;
import com.example.uze.model.Vendedor;
import com.example.uze.services.FilialService;
import com.example.uze.services.VendedorService;

@Controller
@RequestMapping(value = "/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private FilialService filialService;

	@GetMapping("/cadastrar")
	private String cadastrar(Vendedor vendedor) {
		return "/vendedor/cadastro";
	}

	@GetMapping("listar")
	private String listar(ModelMap modelMap) {
		modelMap.addAttribute("vendedores", vendedorService.listar());
		return "/vendedor/lista";
	}

	@PostMapping("/salvar")
	private String salvar(Vendedor vendedor, RedirectAttributes attr, BindingResult result) {
		vendedorService.salvar(vendedor);
		attr.addFlashAttribute("success", "Registro cadastrado com sucesso!");
		return "redirect:/vendedor/cadastrar";
	}
	
	@GetMapping("/editor/{id}")
	private String abrirTelaEditar(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("vendedor", vendedorService.buscarPorId(id));
		return "/vendedor/edicao";
	}

	@PostMapping("/editar")
	private String editar(Vendedor filial, RedirectAttributes attr) {
		vendedorService.salvar(filial);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
		return "redirect:/vendedores/listar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		Vendedor vendedor = vendedorService.buscarPorId(id);
		vendedorService.excluir(vendedor);
		attr.addFlashAttribute("success", "Registro excluido com sucesso.");
		return "redirect:/vemdedores/listar";
	}
	
	@ModelAttribute("filiais")
	private List<Filial> listaDeFiliais() {
		return filialService.listar();
	}
	


}