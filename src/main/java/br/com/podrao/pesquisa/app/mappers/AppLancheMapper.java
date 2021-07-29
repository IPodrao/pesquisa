package br.com.podrao.pesquisa.app.mappers;

import org.mapstruct.Mapper;

import br.com.podrao.pesquisa.app.models.LancheDto;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;

@Mapper
public interface AppLancheMapper {

	CadastrarLancheCommand converter(LancheDto source);

}
