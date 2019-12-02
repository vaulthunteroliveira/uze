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
import com.example.uze.model.Pedido;
import com.example.uze.services.PedidoService;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/cadastrar")
	private String cadastrar(Filial filial) {
		return "/pedido/cadastro";
	}

	@GetMapping("listar")
	private String listar(ModelMap modelMap) {
		modelMap.addAttribute("pedidos", pedidoService.listar());
		return "/pedido/lista";
	}

	@PostMapping("/salvar")
	private String salvar(Pedido pedido, RedirectAttributes attr, BindingResult result) {
		pedidoService.salvar(pedido);
		attr.addFlashAttribute("success", "filial cadastrada com sucesso!");
		return "redirect:/filiais/cadastrar";
	}
	
	@GetMapping("/editor/{id}")
	private String abrirTelaEditar(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("pedido", pedidoService.buscarPorId(id));
		return "/filial/edicao";
	}

	@PostMapping("/editar")
	private String editar(Pedido pedido, RedirectAttributes attr) {
		pedidoService.salvar(pedido);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
		return "redirect:/pedidos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		Pedido pedido = pedidoService.buscarPorId(id);
		pedidoService.excluir(pedido);
		attr.addFlashAttribute("success", "Registro excluido com sucesso.");
		return "redirect:/filiais/listar";
	}
	
}