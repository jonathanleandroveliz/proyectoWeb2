package com.example.proyectoWeb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ProyectoWebApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String passEncriptado = "0181"; //El pass que quieras para el usuario
		System.out.println("PALABRA: " +passEncriptado +" "+pe.encode(passEncriptado));
	}

}
