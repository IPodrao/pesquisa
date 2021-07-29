package br.com.podrao.pesquisa.app.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mapstruct.factory.Mappers;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.podrao.pesquisa.app.mappers.AppCarrinhoMapper;
import br.com.podrao.pesquisa.app.mappers.AppLancheMapper;
import br.com.podrao.pesquisa.app.models.CarrinhoDto;
import br.com.podrao.pesquisa.app.models.LancheDto;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarCarrinho;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarLanche;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

	private final CadastrarCarrinho cadastrarCarrinho;
	private final CadastrarLanche cadastrarLanche;

	private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
			false);

	private AppCarrinhoMapper carrinhoMapper = Mappers.getMapper(AppCarrinhoMapper.class);
	private AppLancheMapper lancheMapper = Mappers.getMapper(AppLancheMapper.class);

	@SneakyThrows
	@KafkaListener(topics = "carrinho_criado")
	public void consomeCarrinhoCriado(ConsumerRecord<String, String> consumerRecord) {

		log.info("received payload='{}'", consumerRecord.toString());
		cadastrarCarrinho
				.executar(carrinhoMapper.converter(mapper.readValue(consumerRecord.value(), CarrinhoDto.class)));
	}

	@SneakyThrows
	@KafkaListener(topics = "lanche_criado")
	public void consomeLancheCriado(ConsumerRecord<String, String> consumerRecord) {

		log.info("received payload='{}'", consumerRecord.toString());
		cadastrarLanche.executar(lancheMapper.converter(mapper.readValue(consumerRecord.value(), LancheDto.class)));
	}
}
