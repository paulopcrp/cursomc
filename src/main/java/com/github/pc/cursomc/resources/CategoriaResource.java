package com.github.pc.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	//requisição basica para obter dados no rest
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest esta funfando";
		
	}

}
