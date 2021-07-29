package br.com.podrao.pesquisa.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@SneakyThrows
	public ListenableFuture<SendResult<String, Object>> send(String topic, Object payload) {

		TimeUnit.MILLISECONDS.sleep(5000);
		log.info("sending payload='{}' to topic='{}'", payload, topic);
		return kafkaTemplate.send(topic, payload);
	}
}