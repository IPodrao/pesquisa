package br.com.podrao.pesquisa.core;

import org.springframework.stereotype.Service;

import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarCarrinho;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarLanche;
import br.com.podrao.pesquisa.core.ports.outgoing.ManutencaoDatabase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManutencaoDadosFacade implements CadastrarCarrinho, CadastrarLanche {

	private final ManutencaoDatabase manutencaoDatabase;
	
	@Override
	public void executar(CadastrarLancheCommand command) {

		manutencaoDatabase.cadastrarLanche(command);
	}

	@Override
	public void executar(CadastrarCarrinhoCommand command) {
		
		manutencaoDatabase.cadastrarCarrinho(command);
	}

}
