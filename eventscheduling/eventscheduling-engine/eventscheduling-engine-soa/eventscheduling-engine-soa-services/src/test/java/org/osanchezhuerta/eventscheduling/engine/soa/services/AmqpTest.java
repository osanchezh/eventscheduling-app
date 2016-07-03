package org.osanchezhuerta.eventscheduling.engine.soa.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/init-engine-soa-services-springctx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AmqpTest {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(AmqpTest.class);
    
	@Test
	public void testAmqpConfiguration(){
		LOGGER.debug("TEST1");
	}
}
