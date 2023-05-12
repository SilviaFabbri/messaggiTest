package it.sinapsi.messaggiTest;
import it.sinapsi.messaggiTest.model.Email;
import jakarta.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


@SpringBootApplication
@EnableJms
public class MessaggiTestApplication {

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

		ConfigurableApplicationContext context = SpringApplication.run(MessaggiTestApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);


		System.out.println("Spedendo un messaggio.");
		jmsTemplate.convertAndSend("casella", new Email("info@sinapsi.it", "Hello"));
	}

}