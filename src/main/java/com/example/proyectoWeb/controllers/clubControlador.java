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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectoWeb.helpers.ViewRouteHelper;
import com.example.proyectoWeb.models.ClubModelo;
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
@RequestMapping("/club")
public class clubControlador {
	
	@Autowired
	@Qualifier("clubService")
	private IClubService clubService;
	
	@GetMapping("/crearClub")
	public ModelAndView  crearTecnico(Model model) {	

		model.addAttribute("club", new ClubModelo());
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.club_FORM);
		//modelAndView.addObject("usuario", user.getUsername());
		
		
		return modelAndView;	
	}

	
	@PostMapping("/nuevoClub")
	public String nuevoJugador(@Valid @ModelAttribute("club")ClubModelo club,
			BindingResult b, @RequestParam("file") MultipartFile imagen , RedirectAttributes redirectAttrs) {
		
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.club_FORM);
		}else {
			if(!imagen.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					club.setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		clubService.insertOrUpdate(club); 
		redirectAttrs
        .addFlashAttribute("mensaje", "Club agregado correctamente")
        .addFlashAttribute("clase", "success");
		mV.setViewName(ViewRouteHelper.tecnico_FORM);
		mV.addObject("club", club);
		
		//Podríamos tambien agregarle las personas que tenemos en la BD
		//mV.addObject("listaTecnico",tecnicoService.getAll());
		}
		
		return "redirect:/jugador/crearTecnico";
		}	
}
