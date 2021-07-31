package br.com.podrao.pesquisa.infra.mappers;

import org.mapstruct.Mapper;

import br.com.podrao.pesquisa.app.models.LancheDto;
import br.com.podrao.pesquisa.infra.entities.LancheEntity;

@Mapper
public interface InfraLancheMapper {

	LancheDto converter(LancheEntity source);
}
