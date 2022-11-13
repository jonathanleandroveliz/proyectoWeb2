package com.example.proyectoWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.proyectoWeb.models.JugadorModelo;
import com.example.proyectoWeb.models.TecnicoModelo;
import com.example.proyectoWeb.models.UsuarioModelo;
import com.example.proyectoWeb.services.IClubService;
import com.example.proyectoWeb.services.IJugadorService;
import com.example.proyectoWeb.services.ITecnicoService;
import com.example.proyectoWeb.services.IUserService;
import com.example.proyectoWeb.services.implementation.UserService;
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
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/crearTecnico")
	public ModelAndView  crearTecnico(Model model) {	

		model.addAttribute("tecnico", new TecnicoModelo());
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.tecnico_FORM);
		//modelAndView.addObject("usuario", user.getUsername());
		
		
		return modelAndView;	
	}

	@PostMapping("/nuevotecnico")
	public String nuevoJugador(@Valid @ModelAttribute("tecnico")TecnicoModelo tecnico,
			BindingResult b, @RequestParam("file") MultipartFile imagen , RedirectAttributes redirectAttrs) {
		
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.tecnico_FORM);
		}else {
			if(!imagen.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					tecnico.setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		tecnicoService.insertOrUpdate(tecnico); 
		redirectAttrs
        .addFlashAttribute("mensaje", "Tecnico agregado correctamente")
        .addFlashAttribute("clase", "success");
		mV.setViewName(ViewRouteHelper.tecnico_FORM);
		mV.addObject("tecnico", tecnico);
		
		//Podríamos tambien agregarle las personas que tenemos en la BD
		//mV.addObject("listaTecnico",tecnicoService.getAll());
		}
		
		return "redirect:/jugador/crearTecnico";
		}	
	
	
	
	@GetMapping("/crearUsuario")
	public ModelAndView  crearUsuario(Model model) {	

		com.example.proyectoWeb.entities.User usuario = new com.example.proyectoWeb.entities.User();
		model.addAttribute("usuario", usuario);
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.usuario_form);
		//modelAndView.addObject("usuario", user.getUsername());
		
		
		return modelAndView;	
	}
	
	
	@PostMapping("/nuevousuario")
	public String nuevoJugador(@Valid @ModelAttribute("usuario")com.example.proyectoWeb.entities.User usuario,RedirectAttributes redirectAttrs) {
		ModelAndView mV = new ModelAndView();
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
	String password = pe.encode(usuario.getPassword());
	usuario.setPassword(password);
		
	userService.insertOrUpdate(usuario);
	redirectAttrs
    .addFlashAttribute("mensaje", "Usuario creado correctamente")
    .addFlashAttribute("clase", "success");
	mV.setViewName(ViewRouteHelper.usuario_form);
	mV.addObject("usuario", usuario);
		
	return "redirect:/jugador/crearUsuario"; 
				
	}
	
	@PreAuthorize("hasRole('ROLE_2')")
	@GetMapping("/crearJugador")
	public ModelAndView  crearJugador(Model model) {	

		model.addAttribute("jugador", new JugadorModelo());
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.JUGADOR_FORM);
		//modelAndView.addObject("usuario", user.getUsername());
		
		
		return modelAndView;	
	}
	
	@PostMapping("/nuevojugador")
	public String nuevoJugador(@Valid @ModelAttribute("jugador")JugadorModelo jugador,
			BindingResult b, @RequestParam("file") MultipartFile imagen,RedirectAttributes redirectAttrs) {
		System.out.println("---->>>" + jugador);
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.JUGADOR_FORM);
		}else {
			if(!imagen.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					jugador.setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		jugadorService.insertOrUpdate(jugador); 
		redirectAttrs
        .addFlashAttribute("mensaje", "Jugador agregado correctamente")
        .addFlashAttribute("clase", "success");
		mV.setViewName(ViewRouteHelper.JUGADOR_FORM);
		mV.addObject("jugador", jugador);
		
		//Podríamos tambien agregarle las personas que tenemos en la BD
		//mV.addObject("listaJugador",jugadorService.getAll());
		}
		
		return "redirect:/jugador/crearJugador";
		}	
	
	
	
	@GetMapping("/editarJugador/{id}")
	public ModelAndView  editarJugador(@PathVariable("id")int id, Model model) {	
		
		
		
		JugadorModelo jugador = jugadorService.traerPorId(id);
		//jugador.setId(id);
		model.addAttribute("jugador", jugador);
			System.out.println("------ " + jugador);	

		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.JUGADOR_FORM);
		
		return modelAndView;	
	}
	
	@GetMapping("/eliminarJugador/{id}")
	public ModelAndView  eliminarJugador(@PathVariable("id")int id, Model model) {	

	
		jugadorService.remove(id);
		
		
		return crudJugadores();	
	}
	
	
	@GetMapping("/detalles/{id}")
	public ModelAndView  detalles(@PathVariable("id")int id, Model model) {	

		JugadorModelo jugador = jugadorService.traerPorId(id);
	

		model.addAttribute("jugador", jugador);
	

		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.detalle_jugador);


		return modelAndView;	
	}


	
	
	@GetMapping("/listajugadores")
	public ModelAndView  listajugadores() {
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.lista_jugador);
		mV.addObject("listaJugador",jugadorService.getAll());
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_3')")
	@GetMapping("/crudJugadores")
	public ModelAndView  crudJugadores() {
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.crud_jugador);
		mV.addObject("listaJugador",jugadorService.getAll());
		return mV;
	}
	
	
	
	@GetMapping("/club2")
	public ModelAndView  club2() {
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.crud);
		mV.addObject("listaJugador",jugadorService.getAll());
		return mV;
	}
	
}




