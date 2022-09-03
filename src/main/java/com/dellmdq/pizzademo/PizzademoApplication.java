package com.dellmdq.pizzademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzademoApplication {
	//todo faltan test
	//todo agregar los loggers a los request y response
	//todo documentar endpoints swagger https://www.youtube.com/watch?v=PLJVQo3SNLw
	//todo agregar collections postman al proyecto
	//todo armar import.sql para datos de prueba iniciales
	//todo demo con peek o obs para mostrar funcionalidad
	//todo chequear regex validacion de algunos campos telefono, email, UUID (?)
	//todo optional mejorar los mapeos de entity a dto
	//fixme: ojo mezclando español con inglés
	public static void main(String[] args) {
		SpringApplication.run(PizzademoApplication.class, args);
	}

}
