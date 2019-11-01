package com.example.springbootjms.sender;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class SenderConfig {

	@Value("${broker-url}")
	private String brokerUrl;

	@Bean
	public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		return activeMQConnectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(senderActiveMQConnectionFactory());
//		jmsTemplate.setPubSubDomain(true);
//		jmsTemplate.setReceiveTimeout(1000);
//		jmsTemplate.setTimeToLive(36000);
//		jmsTemplate.setDeliveryMode(2);  //PERSISTENT
		return jmsTemplate;
	}

	@Bean
	public Sender sender() {
		return new Sender();
	}

}
