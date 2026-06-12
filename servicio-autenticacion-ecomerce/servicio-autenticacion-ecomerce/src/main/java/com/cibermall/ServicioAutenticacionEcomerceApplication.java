package com.cibermall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioAutenticacionEcomerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioAutenticacionEcomerceApplication.class, args);
	}

}
