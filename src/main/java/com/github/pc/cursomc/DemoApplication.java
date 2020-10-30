package com.github.pc.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.pc.cursomc.domain.Categoria;
import com.github.pc.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Exames de Imagem");
		Categoria cat2 = new Categoria(null, "Exames rotina");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
