package br.com.podrao.pesquisa.core.ports.incoming;

import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;

public interface CadastrarLanche {

	void executar(CadastrarLancheCommand command);

}
