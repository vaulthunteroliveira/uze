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

import com.example.uze.model.Filial;
import com.example.uze.services.FilialService;

@Controller
@RequestMapping(value = "/filiais")
public class FilialController {

	@Autowired
	private FilialService filialService;

	@GetMapping("/cadastrar")
	private String cadastrar(Filial filial) {
		return "/filial/cadastro";
	}

	@GetMapping("listar")
	private String listar(ModelMap modelMap) {
		modelMap.addAttribute("filiais", filialService.listar());
		return "/filial/lista";
	}

	@PostMapping("/salvar")
	private String salvar(Filial filial, RedirectAttributes attr, BindingResult result) {
		filialService.salvar(filial);
		attr.addFlashAttribute("success", "filial cadastrada com sucesso!");
		return "redirect:/filiais/cadastrar";
	}
	
	@GetMapping("/editor/{id}")
	private String abrirTelaEditar(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("filial", filialService.buscarPorId(id));
		return "/filial/edicao";
	}

	@PostMapping("/editar")
	private String editar(Filial filial, RedirectAttributes attr) {
		filialService.salvar(filial);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
		return "redirect:/filiais/listar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		Filial filial = filialService.buscarPorId(id);
		filialService.excluir(filial);
		attr.addFlashAttribute("success", "Registro excluido com sucesso.");
		return "redirect:/filiais/listar";
	}
	
	@GetMapping("/dashboad/{id}")
	private String abrirDashboard(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("filial", filialService.buscarPorId(id));
		return "/filial/dashboard";
	}

}