package com.github.pc.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.pc.cursomc.domain.Categoria;
import com.github.pc.cursomc.domain.Cidade;
import com.github.pc.cursomc.domain.Estado;
import com.github.pc.cursomc.domain.Produto;
import com.github.pc.cursomc.repositories.CategoriaRepository;
import com.github.pc.cursomc.repositories.CidadeRepository;
import com.github.pc.cursomc.repositories.EstadoRepository;
import com.github.pc.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Exames de Imagem");
		Categoria cat2 = new Categoria(null, "Exames rotina");
		
		Produto p1 = new Produto(null, "tomografia", 2000.00);
		Produto p2 = new Produto(null, "hemograma", 30.00);
		Produto p3 = new Produto(null, "plaquetas", 60.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		/*  instanciando as Cidades e os Estados 28/12/2020 */
		
		Estado est1 = new Estado(null, "Rio Grande do Sul");
		Estado est2 = new Estado(null, "Santa Catarina");
		Estado est3 = new Estado(null, "Parana");
		
		Cidade c1 = new Cidade(null, "Porto Alegre", est1);
		Cidade c2 = new Cidade(null, "Caxias do Sul", est1);
		Cidade c3 = new Cidade(null, "Curitiba", est3);
		Cidade c4 = new Cidade(null, "Guarda do Embau", est2);
		Cidade c5 = new Cidade(null, "Florianopolis", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c4, c5));
		est3.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
	}

}
