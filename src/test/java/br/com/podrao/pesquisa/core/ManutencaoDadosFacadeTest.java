package br.com.podrao.pesquisa.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;
import br.com.podrao.pesquisa.core.ports.outgoing.ManutencaoDatabase;

@ExtendWith(MockitoExtension.class)
@DisplayName("Core: Manutenção de dados")
class ManutencaoDadosFacadeTest {

	@Mock
	private ManutencaoDatabase manutencaoDatabase;
	
	@InjectMocks
	private ManutencaoDadosFacade manutencaoDadosFacade;
	
	@Test
	@DisplayName("Tenta cadastrar carrinho")
	void cadastrarCarrinho() {
	
		CadastrarCarrinhoCommand command = new CadastrarCarrinhoCommand(1L, "Carrinho do zé", 045645D, 40564D);
		
		doReturn(null).when(manutencaoDatabase).cadastrarCarrinho(any(CadastrarCarrinhoCommand.class));
		
		assertDoesNotThrow(() -> manutencaoDadosFacade.executar(command));
	}
	
	@Test
	@DisplayName("Tenta cadastrar lanche")
	void cadastrarLanche() {

		CadastrarLancheCommand command = new CadastrarLancheCommand(1L, "Enourmous Buguer", BigDecimal.valueOf(23), 1L);
		
		doReturn(null).when(manutencaoDatabase).cadastrarLanche(any(CadastrarLancheCommand.class));
		
		assertDoesNotThrow(() -> manutencaoDadosFacade.executar(command));
	}
}
