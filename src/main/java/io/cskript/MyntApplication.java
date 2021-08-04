package io.cskript;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:domain-service-context.xml"})
public class MyntApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyntApplication.class, args);
	}

}
