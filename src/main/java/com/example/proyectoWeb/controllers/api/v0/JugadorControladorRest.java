package com.example.proyectoWeb.controllers.api.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.proyectoWeb.entities.Jugador;
import com.example.proyectoWeb.models.JugadorModelo;
import com.example.proyectoWeb.models.request.JugadorRequest;
import com.example.proyectoWeb.services.IClubService;
import com.example.proyectoWeb.services.IJugadorService;
import com.example.proyectoWeb.services.ITecnicoService;
import com.example.proyectoWeb.services.IUserService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/jugador")
public class JugadorControladorRest {
	
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
	
	@Operation(summary="Muestra Todos los jugadores de BD", description = "Me trae todo los jugadores de la BD")
	@GetMapping("/all")
	public ResponseEntity<List<JugadorModelo>> todasLasPersonas(){

		List<JugadorModelo> jugador = new ArrayList<JugadorModelo>();
		jugador.add(new JugadorModelo("Nico","Fernandez" ,33, "Argentina"));
		jugador.add(new JugadorModelo("Brenda","Natali", 48, "Brasil"));

		return new ResponseEntity<List<JugadorModelo>>(jugador, HttpStatus.OK);


	}
	
	@Operation(summary="Lista de jugadores", description = "Devuelve la lista de jugadores ")
	@GetMapping("/listaDeJugadores")
	public ResponseEntity<Object> todasLasPersonasBD(){
		
		List<Jugador> listajugador= jugadorService.getAll();
		
		Object body = "Lista vacia";
				
		if(listajugador != null) {
			body = listajugador;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(body);
		
		
	}
	
	
	@Operation(summary="Eliminar jugador por id", description = "Elimina a un jugador con su determinado id")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarJugador(@PathVariable("id") int id) {
		
	
	    boolean isRemoved = jugadorService.remove(id);
	 
	    		
	    if (!isRemoved) {
	    	Object body ="No se puedo eliminar";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body("Eliminado id: " +id);
	}
	
	@Operation(summary="Agrega una persona y su avatar", description = "Seguarda en la base de datos la persona y su correspondiente avatar, figuritas y paises nulos.")
	@PostMapping("/agregarPersona")
	public ResponseEntity<Object> agregar(@RequestBody JugadorRequest jugador){
		
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		
		JugadorModelo j = new JugadorModelo();
		
		
		j.setEdad(jugador.getEdad());
		j.setNombre(jugador.getNombre());
		j.setApellido(jugador.getApellido());
		j.setPais(jugador.getPais());
		j.setCategoria(jugador.getCategoria());
		j.setPosicion(jugador.getPosicion());
		
		try {
			 JugadorModelo jugadorAgregado = jugadorService.insertOrUpdate(j); 
			body = jugadorAgregado;
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			body = "Error de la excepcion: " + e.getMessage(); 
		}
		
		return ResponseEntity.status(status).body(body);
	}
	
	@Operation(summary="Trae jugador por id", description = "Trae a un jugador")
	@GetMapping("/traer/{id}")
	public ResponseEntity<Object> traerJugador(@PathVariable("id") int id) {
		
	
	    JugadorModelo p = jugadorService.traerPorId(id);
	    Object body;
	    		
	    if (p == null) {
	    	body ="No se puedo traer al jugador";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@Operation(summary="Edita un jugador", description = "Se actualizan los datos .")
	@PutMapping("/editarPersona/{id}")
	public ResponseEntity<Object> editar(@PathVariable int id, 
			@RequestBody JugadorRequest jugador){
		
	
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		
		
		JugadorModelo j = jugadorService.traerPorId(id);
		
		j.setEdad(jugador.getEdad());
		j.setNombre(jugador.getNombre());
		j.setApellido(jugador.getApellido());
		j.setPais(jugador.getPais());
		j.setCategoria(jugador.getCategoria());
		j.setPosicion(jugador.getPosicion());
		
		
		try {
			 JugadorModelo personaAgregada = jugadorService.insertOrUpdate(j); 
			body = personaAgregada;
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			body = "Error de la excepcion: " + e.getMessage(); 
		}
		
		return ResponseEntity.status(status).body(body);
	}
	
	

}
