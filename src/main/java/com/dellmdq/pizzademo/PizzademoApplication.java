package com.dellmdq.pizzademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzademoApplication {
	//todo faltan test
	//todo armar import.sql para datos de prueba iniciales
	//todo agregar los loggers a los request y response
	//todo agregar collections postman al proyecto
	//todo demo con peek o obs para mostrar funcionalidad
	//todo openapi
	//chequear regex validacion de algunos campos telefono, email, UUID (?)
	public static void main(String[] args) {
		SpringApplication.run(PizzademoApplication.class, args);
	}

}
