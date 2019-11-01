package com.example.springjmsreceiver.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ReceiverConfig {
	@Value("${broker-url}")
	private String brokerUrl;

	@Bean
	public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		return activeMQConnectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {

		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsListenerContainerFactory.setConnectionFactory(receiverActiveMQConnectionFactory());
		// defaultJmsListenerContainerFactory.setPubSubDomain(true);
		return defaultJmsListenerContainerFactory;
	}

	// For sending the message
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(receiverActiveMQConnectionFactory());
		// jmsTemplate.setPubSubDomain(true);
		// jmsTemplate.setReceiveTimeout(1000);
		// jmsTemplate.setTimeToLive(36000);
		// jmsTemplate.setDeliveryMode(2); //PERSISTENT
		return jmsTemplate;
	}

	//
	// @Bean
	// public Receiver receiver() {
	// return new Receiver();
	// }
}
