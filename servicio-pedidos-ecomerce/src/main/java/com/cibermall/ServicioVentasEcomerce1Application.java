package com.cibermall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServicioVentasEcomerce1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVentasEcomerce1Application.class, args);
	}

}
