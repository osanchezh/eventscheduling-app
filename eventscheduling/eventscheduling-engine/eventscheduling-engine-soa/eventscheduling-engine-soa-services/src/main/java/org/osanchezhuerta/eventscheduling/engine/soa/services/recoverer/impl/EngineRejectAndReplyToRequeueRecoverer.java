package org.osanchezhuerta.eventscheduling.engine.soa.services.recoverer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;  
  

public class EngineRejectAndReplyToRequeueRecoverer extends RejectAndDontRequeueRecoverer  
{  
	private static final Logger LOGGER =  LoggerFactory.getLogger(EngineRejectAndReplyToRequeueRecoverer.class);

	private AmqpTemplate amqpTemplate;
  

	@Override  
    public void recover(Message message, Throwable cause)  
    { 
	
		LOGGER.debug("recuperacion");
		LOGGER.error(cause.getMessage(),cause);

        MessageProperties mp = message.getMessageProperties();  
        /*
        if (mp != null && StringUtils.isNotBlank(mp.getReplyTo()) && replyToTemplate != null)  
        {  
            Map<String, Object> headers = mp.getHeaders();  
            System.err.println(headers.toString());  
            Object vLang = headers.get(PropKeys.LANG);  
            String lang = "en";  
            if (vLang != null)  
            {  
                lang = (String) vLang;  
            }  
            com.test.utils.Message rejectRespMsg = new com.test.utils.Message(false);  
            rejectRespMsg.setPayload(null);  
            MessageUtil.changeResult(rejectRespMsg, "test.rabbit.replyto.interceptor.illegal.request", lang);  
            Address address = new Address(mp.getReplyTo());  
            replyToTemplate.convertAndSend(address.getExchangeName(), address.getRoutingKey(), rejectRespMsg);  
        }  */
        super.recover(message, cause);  
    }  
  

    public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
  
}  