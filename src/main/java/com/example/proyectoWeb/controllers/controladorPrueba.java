package com.example.proyectoWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.proyectoWeb.helpers.*;

@Controller
@RequestMapping("/test")
public class controladorPrueba {
	
	@GetMapping("uno")
	public String iniciandoElCursos1() {
		
			return ViewRouteHelper.error403;
		
		
	} 
	@GetMapping("dos")
	public String iniciandoElCursos2() {
		
			return ViewRouteHelper.error404;
		
		
	} 
	@GetMapping("tres")
	public String iniciandoElCursos3() {
		
			return ViewRouteHelper.error500;
		
		
	} 
	@GetMapping("cuatro")
	public String iniciandoElCursos4() {
		
			return ViewRouteHelper.USER_LOGIN;
		
		
	} 
	@GetMapping("cinco")
	public String iniciandoElCursos5() {
		
			return ViewRouteHelper.USER_LOGOUT;
		
		
	} 
	
	@GetMapping("seis")
	public String iniciandoElCursos6() {
		
			return ViewRouteHelper.TABLA_JUGADOR;
		
		
	} 

}
