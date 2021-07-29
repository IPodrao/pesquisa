package br.com.podrao.pesquisa.core;

import org.springframework.stereotype.Service;

import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarCarrinho;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarLanche;

@Service
public class ManutencaoDadosFacade implements CadastrarCarrinho, CadastrarLanche {

	@Override
	public void executar(CadastrarLancheCommand command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executar(CadastrarCarrinhoCommand command) {
		// TODO Auto-generated method stub
		
	}

}
