package br.com.yuri.projetoweb;

import br.com.yuri.projetoweb.domain.Categoria;
import br.com.yuri.projetoweb.domain.Cidade;
import br.com.yuri.projetoweb.domain.Estado;
import br.com.yuri.projetoweb.domain.Produto;
import br.com.yuri.projetoweb.repositories.CategoriaRepository;
import br.com.yuri.projetoweb.repositories.CidadeRepository;
import br.com.yuri.projetoweb.repositories.EstadoRepository;
import br.com.yuri.projetoweb.repositories.ProdutoRepository;
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

	@Autowired
	private ProdutoRepository prod;

	@Autowired
	private CidadeRepository city;

	@Autowired
	private EstadoRepository est;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		Produto p1 = new Produto(null, "Computador",2000.00 );
		Produto p2 = new Produto(null, "Impressora",800.00 );
		Produto p3 = new Produto(null, "Mouse",80.00 );

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCat().addAll(Arrays.asList(cat1));
		p2.getCat().addAll(Arrays.asList(cat1,cat2));
		p3.getCat().addAll(Arrays.asList(cat1));


		cat.saveAll(Arrays.asList(cat1,cat2));
		prod.saveAll(Arrays.asList(p1,p2,p3));


		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cit1 = new Cidade(null, "Uberlandia",est1);
		Cidade cit2 = new Cidade(null, "São paulo",est2);
		Cidade cit3 = new Cidade(null, "Campinas",est2);

		est1.getCidades().addAll(Arrays.asList(cit1));
		est2.getCidades().addAll(Arrays.asList(cit2,cit2));

		est.saveAll(Arrays.asList(est1,est2));
		city.saveAll((Arrays.asList(cit1,cit2,cit3)));





	}
}
