package br.com.podrao.pesquisa.core.ports.incoming;

import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;

public interface CadastrarCarrinho {

	void executar(CadastrarCarrinhoCommand command);
}