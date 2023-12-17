package com.example.proyectoWeb.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.proyectoWeb.helpers.ViewRouteHelper;
import com.example.proyectoWeb.services.IJugadorService;
import com.example.proyectoWeb.services.ITecnicoService;





@Controller
@RequestMapping("tecnico")
public class tecnicoControlador {
	
	@Autowired
	@Qualifier("tecnicoService")
	private  ITecnicoService tecnicoService;
	
	@GetMapping("/listatecnico")
	public ModelAndView  listajugadores() {
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.lista_tecnico);
		mV.addObject("listaTecnico",tecnicoService.getAll());
		return mV;
	}
}