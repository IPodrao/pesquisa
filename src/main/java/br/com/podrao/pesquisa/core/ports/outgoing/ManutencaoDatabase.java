package br.com.podrao.pesquisa.core.ports.outgoing;

import br.com.podrao.pesquisa.app.models.CarrinhoDto;
import br.com.podrao.pesquisa.app.models.LancheDto;
import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;

public interface ManutencaoDatabase {

	CarrinhoDto cadastrarCarrinho(CadastrarCarrinhoCommand command);

	LancheDto cadastrarLanche(CadastrarLancheCommand command);
}