package br.com.podrao.pesquisa.util;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.podrao.pesquisa.app.consumers.KafkaConsumer;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarCarrinho;
import br.com.podrao.pesquisa.core.ports.incoming.CadastrarLanche;
import lombok.Getter;
import lombok.SneakyThrows;

@Primary
@Component
public class KafkaConsumerStub extends KafkaConsumer {

	@Getter
	private CountDownLatch latch = new CountDownLatch(1);
	
	public KafkaConsumerStub(CadastrarCarrinho cadastrarCarrinho, CadastrarLanche cadastrarLanche) {
		super(cadastrarCarrinho, cadastrarLanche);
	}
	
	public void consomeCarrinhoCriado(ConsumerRecord<String, String> consumerRecord) {

		super.consomeCarrinhoCriado(consumerRecord);
		latch.countDown();
	}
	
	@SneakyThrows
	@KafkaListener(topics = "lanche_criado")
	public void consomeLancheCriado(ConsumerRecord<String, String> consumerRecord) {

		super.consomeLancheCriado(consumerRecord);
		latch.countDown();
	}
}
