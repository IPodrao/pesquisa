package br.com.podrao.pesquisa.app.mappers;

import org.mapstruct.Mapper;

import br.com.podrao.pesquisa.app.models.CarrinhoDto;
import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;

@Mapper
public interface AppCarrinhoMapper {

	CadastrarCarrinhoCommand converter(CarrinhoDto source);

}
