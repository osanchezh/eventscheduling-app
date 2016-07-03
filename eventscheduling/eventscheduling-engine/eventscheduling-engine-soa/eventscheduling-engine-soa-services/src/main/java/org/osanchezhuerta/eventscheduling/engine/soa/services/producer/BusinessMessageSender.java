package org.osanchezhuerta.eventscheduling.engine.soa.services.producer;

import org.osanchezhuerta.eventscheduling.engine.soa.commons.exception.EngineAmqpException;

public interface BusinessMessageSender<T> {
    void sendMessage(String message) throws EngineAmqpException;

}
