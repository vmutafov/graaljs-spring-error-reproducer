package com.vmutafov;

import org.graalvm.polyglot.Engine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReproducerApplication.class, args);
	}

	@Bean
	Engine createEngine() {
		try {
			return Engine.create("js");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
