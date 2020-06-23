package br.com.yuri.projetoweb;

import br.com.yuri.projetoweb.domain.*;
import br.com.yuri.projetoweb.repositories.*;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

	@Autowired
	private ClienteRepository cli;

	@Autowired
	private EnderecoRepository end;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

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

		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","46844429978", TipoPessoa.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("993658585","985665521"));

        Endereco e1 = new Endereco(null,"Rua Flores 300", "Apto 303", "Jardim","3656984", cli1, cit1);
		Endereco e2 = new Endereco(null,"Avenida Matos 300", " 150", "Sala 800","3656984", cli1, cit2);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

		cli.saveAll(Arrays.asList(cli1));
		end.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1,e2);

		Pagamento pagto1 = new PagamentoComCartão(null,EstadoPagamento.QUITADO,ped1,6 );
        ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped1.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));


		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));





	}
}
