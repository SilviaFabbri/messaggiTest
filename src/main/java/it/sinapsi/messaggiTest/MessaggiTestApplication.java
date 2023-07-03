package it.sinapsi.messaggiTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import it.sinapsi.messaggiTest.business.ChiusuraInviata;
import it.sinapsi.messaggiTest.business.SimulazioneCassa;
import it.sinapsi.messaggiTest.business.Chiusura;
import jakarta.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Calendar;
import java.util.Timer;
@EnableScheduling
@EnableJms
@SpringBootApplication
public class MessaggiTestApplication {

	@Bean
	@Primary
	public ObjectMapper objectMapper() {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}

	@Bean
	public JmsListenerContainerFactory<?> myFactory(@Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory,
													DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		Timer timer1 = new Timer();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, 9);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		Calendar date1 = Calendar.getInstance();
		date1.set(Calendar.HOUR_OF_DAY, 14);
		date1.set(Calendar.MINUTE, 0);
		date1.set(Calendar.SECOND, 0);

		timer.schedule(new SimulazioneCassa(), date.getTime(), 24 * 60 * 60 * 1000);
		timer.schedule(new Chiusura(timer), date1.getTime(), 24 * 60 * 60 * 1000);
		timer1.schedule(new ChiusuraInviata(), date1.getTime(), 24 * 60 * 60 * 1000);

		SpringApplication.run(MessaggiTestApplication.class, args);

	}

}