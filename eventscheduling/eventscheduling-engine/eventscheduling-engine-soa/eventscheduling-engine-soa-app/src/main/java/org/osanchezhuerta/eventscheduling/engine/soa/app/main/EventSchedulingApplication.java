package org.osanchezhuerta.eventscheduling.engine.soa.app.main;


import org.osanchezhuerta.eventscheduling.engine.soa.commons.constants.EventSchedulingConstants;
import org.osanchezhuerta.eventscheduling.engine.soa.commons.util.EventSchedulingPidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, JmsAutoConfiguration.class })
@ImportResource("classpath:/spring/init-engine-soa-app-springctx.xml")
public class EventSchedulingApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventSchedulingApplication.class);
    
	public static void main(String[] args) {
		LOGGER.debug("init.EventSchedulingApplication");
		ConfigurableApplicationContext configurableAppCtx= null;
		SpringApplication springApp = new SpringApplication(EventSchedulingApplication.class);
		springApp.setWebEnvironment(false);
		String applicationName= EventSchedulingConstants.APPLICATION_NAME;
		String pidFileName = EventSchedulingPidUtil.createPidName(applicationName);
		ApplicationPidFileWriter appPidFileWriter = new ApplicationPidFileWriter(pidFileName);
		springApp.addListeners(appPidFileWriter);
		configurableAppCtx = springApp.run(args);
		configurableAppCtx.registerShutdownHook();
	}

}
