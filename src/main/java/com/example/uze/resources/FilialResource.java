package com.example.uze.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uze.model.Filial;

@RestController
@RequestMapping(value = "/filiais")
public class FilialResource {

	
	@RequestMapping(method=RequestMethod.GET)
	private List<Filial> listar() {
		List<Filial> filiais = new ArrayList<Filial>();
		return filiais;
		
	}
}