package com.example.proyectoWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.proyectoWeb.helpers.ViewRouteHelper;
import com.example.proyectoWeb.models.JugadorModelo;
import com.example.proyectoWeb.models.TecnicoModelo;
import com.example.proyectoWeb.services.IClubService;
import com.example.proyectoWeb.services.IJugadorService;
import com.example.proyectoWeb.services.ITecnicoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("inicio")
public class inicioControlador {
	
	@Autowired
	@Qualifier("jugadorService")
	private IJugadorService jugadorService;
	
	@Autowired
	@Qualifier("clubService")
	private IClubService clubService;
	
	@Autowired
	@Qualifier("tecnicoService")
	private ITecnicoService tecnicoService;
	
	@GetMapping("/index")
	public ModelAndView  inicio() {
		
		
		ModelAndView mV = new ModelAndView();
		mV.addObject("listaJugador",jugadorService.getAll());
		mV.setViewName(ViewRouteHelper.inicio);
		
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
