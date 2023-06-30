package it.sinapsi.messaggiTest;


import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.business.IncassoRepository;
import it.sinapsi.messaggiTest.business.IncassoScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import redis.clients.jedis.ConnectionFactory;

import java.util.Calendar;


@SpringBootApplication
public class MessaggiTestApplication {


	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	public static void main(String[] args) {
		SpringApplication.run(MessaggiTestApplication.class, args);

	}

}