package org.osanchezhuerta.eventscheduling.engine.soa.services.producer.impl;

import org.osanchezhuerta.eventscheduling.engine.soa.commons.exception.EngineAmqpException;
import org.osanchezhuerta.eventscheduling.engine.soa.services.producer.BusinessMessageSender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class EngineIdentityRequestSender implements BusinessMessageSender<String> {

	@Autowired
	private AmqpTemplate template;

	@Override
	public void sendMessage(String message) throws EngineAmqpException {
		MessageProperties properties = new MessageProperties();
		//properties.set
		//Message message = MessageBuilder.withBody(body).
		//template.send(message);
	}

}
