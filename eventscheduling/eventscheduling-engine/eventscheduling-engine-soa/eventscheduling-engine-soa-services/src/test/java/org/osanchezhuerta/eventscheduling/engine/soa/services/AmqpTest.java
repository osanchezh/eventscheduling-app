package org.osanchezhuerta.eventscheduling.engine.soa.services;


import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezhuerta.eventscheduling.engine.soa.model.exchange.IdentityRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/init-engine-soa-services-springctx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AmqpTest {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(AmqpTest.class);
    
	@Autowired
	@Qualifier("engineJacksonObjectMapper")
	private ObjectMapper engineJacksonObjectMapper;

	@Test
	public void testAmqpConfiguration(){
		LOGGER.debug("TEST1");
		
		IdentityRequest identityRequest = new IdentityRequest();
		StringWriter sw = new StringWriter();
		try {
			engineJacksonObjectMapper.writeValue(sw, identityRequest);
			LOGGER.debug("sw="+sw.toString());
		} catch (IOException exception) {
			LOGGER.error(exception.getMessage(),exception);
		}
		
		
	}
	
	public ObjectMapper getEngineJacksonObjectMapper() {
		return engineJacksonObjectMapper;
	}
	public void setEngineJacksonObjectMapper(ObjectMapper engineJacksonObjectMapper) {
		this.engineJacksonObjectMapper = engineJacksonObjectMapper;
	}
}
