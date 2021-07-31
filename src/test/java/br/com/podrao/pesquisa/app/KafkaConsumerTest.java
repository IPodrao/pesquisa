package br.com.podrao.pesquisa.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.podrao.pesquisa.core.models.commands.CadastrarCarrinhoCommand;
import br.com.podrao.pesquisa.core.models.commands.CadastrarLancheCommand;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarCarrinho;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarLanche;
import br.com.podrao.pesquisa.util.CarrinhoDtoStub;
import br.com.podrao.pesquisa.util.KafkaConsumerStub;
import br.com.podrao.pesquisa.util.KafkaProducer;
import br.com.podrao.pesquisa.util.LancheDtoStub;
import lombok.SneakyThrows;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class KafkaConsumerTest {

	@Autowired
	private KafkaConsumerStub consumer;

	@Autowired
	private KafkaProducer producer;

	@MockBean
	private CadastrarCarrinho cadastrarCarrinho;

	@MockBean
	private CadastrarLanche cadastrarLanche;
	
	@Captor
	private ArgumentCaptor<CadastrarCarrinhoCommand> carrinhoCaptor;
	
	@Captor
	private ArgumentCaptor<CadastrarLancheCommand> lancheCaptor;

	private static final String TOPICO_CARRINHO = "carrinho_criado";
	private static final String TOPICO_LANCHE = "lanche_criado";

	@Test
	@DisplayName("Tentar receber mensagem de carrinho criado")
	void recebeMensagemDeCarrinhoCriado() throws Exception {

		CarrinhoDtoStub dto = new CarrinhoDtoStub();
		
		ListenableFuture<SendResult<String, Object>> send = producer.send(TOPICO_CARRINHO, toJson(dto));

		while (!send.isDone()) {
			TimeUnit.MILLISECONDS.sleep(1000);
		}
		consumer.getLatch().await(1000, TimeUnit.MILLISECONDS);

		verify(cadastrarCarrinho, times(1)).executar(carrinhoCaptor.capture());
		
		CadastrarCarrinhoCommand command = carrinhoCaptor.getValue();
		
		assertEquals(dto.getId(), command.getId());
		assertEquals(dto.getNome(), command.getNome());
		assertEquals(dto.getLatitude(), command.getLatitude());
		assertEquals(dto.getLongitude(), command.getLongitude());
	}
	
	@Test
	@DisplayName("Tentar receber mensagem de lanche criado")
	void recebeMensagemDeLancheCriado() throws Exception {

		LancheDtoStub dto = new LancheDtoStub();
		
		ListenableFuture<SendResult<String, Object>> send = producer.send(TOPICO_LANCHE, toJson(dto));

		while (!send.isDone()) {
			TimeUnit.MILLISECONDS.sleep(1000);
		}
		consumer.getLatch().await(1000, TimeUnit.MILLISECONDS);
		verify(cadastrarLanche, times(1)).executar(lancheCaptor.capture());
		
		CadastrarLancheCommand command = lancheCaptor.getValue();
		
		assertEquals(dto.getId(), command.getId());
		assertEquals(dto.getNome(), command.getNome());
		assertEquals(dto.getValor(), command.getValor());
		assertEquals(dto.getCarrinhoId(), command.getCarrinhoId());
	}

	@SneakyThrows
	private String toJson(Object value) {

		return new ObjectMapper().writeValueAsString(value);
	}
}
