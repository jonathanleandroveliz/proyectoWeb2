package com.example.proyectoWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.proyectoWeb.models.JugadorModelo;
import com.example.proyectoWeb.services.IClubService;
import com.example.proyectoWeb.services.IJugadorService;
import com.example.proyectoWeb.services.ITecnicoService;
import com.example.proyectoWeb.helpers.ViewRouteHelper;

@Controller
@RequestMapping("jugador")
public class JugadorControlador {

	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("clubService")
	private IClubService clubService;
	
	@Autowired
	@Qualifier("tecnicoService")
	private ITecnicoService tecnicoService;

	
	@GetMapping("/crearJugador")
	public ModelAndView  crearJugador(Model model) {	

		model.addAttribute("jugador", new JugadorModelo());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.JUGADOR_FORM);
		modelAndView.addObject("usuario", user.getUsername());
		return modelAndView;	
	}
	
	
	@PostMapping("/nuevojugador")
	public ModelAndView nuevoJugador(@Valid @ModelAttribute("jugador")JugadorModelo jugador,
			BindingResult b) {
		
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.JUGADOR_FORM);
		}else {
			
			jugadorService.insertOrUpdate(jugador); 
			mV.setViewName(ViewRouteHelper.JUGADOR_NEW);
			mV.addObject("jugador", jugador);
			
			//Podríamos tambien agregarle las personas que tenemos en la BD
			mV.addObject("listaJugador",jugadorService.getAll());
			

		}

		return mV;
	}
	
	@GetMapping("/tablaJugador")
	public ModelAndView  tablaJugador() {
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.TABLA_JUGADOR);
		mV.addObject("listaJugador",jugadorService.getAll());
		mV.addObject("listaTecnico", tecnicoService.getAll());
		mV.addObject("listaClub", clubService.getAll());
		return mV;
	}
	
	
	
	@GetMapping("/club")
	public ModelAndView  club() {
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.TABLA_CLUB);
		mV.addObject("listaClub", clubService.getAll());
		return mV;
	}
	
}



