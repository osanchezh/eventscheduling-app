package org.osanchezhuerta.eventscheduling.engine.soa.app.main;


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
@ImportResource("classpath:/DESA_init-bpm-lite-config.xml")
public class EventSchedulingApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventSchedulingApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableAppCtx= null;
		SpringApplication springApp = new SpringApplication(EventSchedulingApplication.class);
		springApp.setWebEnvironment(false);
		ApplicationPidFileWriter appPidFileWriter = new ApplicationPidFileWriter("./d29BpmnLiteApplication.pid");
		springApp.addListeners(appPidFileWriter);
		configurableAppCtx = springApp.run(args);
		configurableAppCtx.registerShutdownHook();
	}

}
