package com.example.proyectoWeb.converters;

import org.springframework.stereotype.Component;
import com.example.proyectoWeb.entities.Jugador;
import com.example.proyectoWeb.models.JugadorModelo;


@Component("jugadorConverter")
public class JugadorConverter {
	
	public JugadorModelo entityToModel(Jugador jugador) {

		return new JugadorModelo(jugador.getNombre(), jugador.getApellido() ,jugador.getEdad(), jugador.getPais(),
				jugador.getPosicion(),jugador.getCategoria(), jugador.getImagen(), jugador.getValuacion());


	}



	public Jugador modelToEntity(JugadorModelo jugadorModelo) {

		return new Jugador(jugadorModelo.getId(), jugadorModelo.getNombre(),jugadorModelo.getApellido(), jugadorModelo.getEdad(), 
				jugadorModelo.getPais(), jugadorModelo.getPosicion() ,jugadorModelo.getCategoria(), jugadorModelo.getImagen(), jugadorModelo.getValuacion());


	}

}
