package br.com.podrao.pesquisa.infra;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import br.com.podrao.pesquisa.app.models.CarrinhoDto;
import br.com.podrao.pesquisa.app.models.LancheDto;
import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;
import br.com.podrao.pesquisa.core.ports.outgoing.ManutencaoDatabase;
import br.com.podrao.pesquisa.infra.entities.CarrinhoEntity;
import br.com.podrao.pesquisa.infra.entities.LancheEntity;
import br.com.podrao.pesquisa.infra.mappers.InfraCarrinhoMapper;
import br.com.podrao.pesquisa.infra.mappers.InfraLancheMapper;
import br.com.podrao.pesquisa.infra.repositories.CarrinhoRepository;
import br.com.podrao.pesquisa.infra.repositories.LancheRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ManutencaoDadosAdapter implements ManutencaoDatabase {

	private final CarrinhoRepository carrinhoRepository;
	private final LancheRepository lancheRepository;

	private InfraCarrinhoMapper carrinhoMapper = Mappers.getMapper(InfraCarrinhoMapper.class);
	private InfraLancheMapper lancheMapper = Mappers.getMapper(InfraLancheMapper.class);

	@Override
	public CarrinhoDto cadastrarCarrinho(CadastrarCarrinhoCommand command) {

		return carrinhoMapper.converter(carrinhoRepository.save(
				new CarrinhoEntity(command.getId(), command.getNome(), command.getLatitude(), command.getLongitude())));
	}

	@Override
	public LancheDto cadastrarLanche(CadastrarLancheCommand command) {

		return lancheMapper.converter(lancheRepository.save(
				new LancheEntity(command.getId(), command.getNome(), command.getValor(), command.getCarrinhoId())));
	}

}
