package org.osanchezhuerta.eventscheduling.engine.soa.services.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class EngineIdentityDlqListener implements MessageListener {

	@Override
	public void onMessage(Message message) {

		
		
	}

}
