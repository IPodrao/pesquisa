package br.com.podrao.pesquisa.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.podrao.pesquisa.app.models.CarrinhoDto;
import br.com.podrao.pesquisa.app.models.LancheDto;
import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;
import br.com.podrao.pesquisa.infra.repositories.CarrinhoRepository;
import br.com.podrao.pesquisa.infra.repositories.LancheRepository;

@DataJpaTest
@DisplayName("Infra: Manutenção de dados")
class ManutencaoDadosAdapterTest{

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private LancheRepository lancheRepository;
	
	private ManutencaoDadosAdapter dadosAdapter;
	
	@BeforeEach
	void setup() {
		
		this.dadosAdapter = new ManutencaoDadosAdapter(carrinhoRepository, lancheRepository);
	}
	
	@Test
	@DisplayName("Tenta cadastrar carrinho")
	void cadastrarCarrinho() {
		 
		CadastrarCarrinhoCommand command = new CadastrarCarrinhoCommand(7L, "Carrinho do zé", 45645D, 40564D);
		
		CarrinhoDto carrinho = dadosAdapter.cadastrarCarrinho(command);
		
		assertEquals(command.getId(), carrinho.getId());
		assertEquals(command.getNome(), carrinho.getNome());
		assertEquals(command.getLatitude(), carrinho.getLatitude());
		assertEquals(command.getLongitude(), carrinho.getLongitude());
	}
	
	@Test
	@DisplayName("Tenta cadastrar lanche")
	void cadastrarLanche() {
		
		CadastrarLancheCommand command = new CadastrarLancheCommand(1L, "Enourmous Buguer", BigDecimal.valueOf(23), 1L);
		
		LancheDto lanche = dadosAdapter.cadastrarLanche(command);
		
		assertEquals(command.getId(), lanche.getId());
		assertEquals(command.getCarrinhoId(), lanche.getCarrinhoId());
		assertEquals(command.getNome(), lanche.getNome());
		assertEquals(command.getValor(), lanche.getValor());
	}
}