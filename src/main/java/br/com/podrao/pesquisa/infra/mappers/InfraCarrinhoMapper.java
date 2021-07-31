package br.com.podrao.pesquisa.infra.mappers;

import org.mapstruct.Mapper;

import br.com.podrao.pesquisa.app.models.CarrinhoDto;
import br.com.podrao.pesquisa.infra.entities.CarrinhoEntity;

@Mapper
public interface InfraCarrinhoMapper {

	CarrinhoDto converter(CarrinhoEntity source);
}
