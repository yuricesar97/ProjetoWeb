package br.com.yuri.projetoweb;

import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.repositories.CategoriaRepository;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjetoWebApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository cat;
	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		cat.saveAll(Arrays.asList(cat1,cat2));


	}
}
