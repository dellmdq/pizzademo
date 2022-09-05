package com.dellmdq.pizzademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzademoApplication {

	//todo demo con peek o obs para mostrar funcionalidad

	//todo chequear regex validacion de algunos campos telefono, email, UUID (?)
	//todo optional mejorar los mapeos de entity a dto
	public static void main(String[] args) {
		SpringApplication.run(PizzademoApplication.class, args);
	}

}
