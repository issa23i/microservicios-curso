package com.nttdata.microservicios.app.cursos;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan({"com.nttdata.microservicios.commons.alumnos.models.entity",
			 "com.nttdata.microservicios.app.cursos.models.entity"})
public class MicroserviciosCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursoApplication.class, args);
	}

}
