package com.dmx.server;

import com.dmx.shared.kernel.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
		value = "com.dmx"
)
public class MicroserviceSocialGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSocialGraphApplication.class, args);
	}

}
