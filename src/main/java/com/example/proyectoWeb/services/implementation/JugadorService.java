package com.example.proyectoWeb.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyectoWeb.entities.Jugador;
import com.example.proyectoWeb.models.JugadorModelo;
import com.example.proyectoWeb.repositories.IJugadorRepository;
import com.example.proyectoWeb.services.IJugadorService;
import com.example.proyectoWeb.converters.JugadorConverter;


@Service("jugadorService")
public class JugadorService implements IJugadorService {
	
	@Autowired
	@Qualifier("jugadorRepository")
	private IJugadorRepository jugadorRepository;

	@Autowired
	@Qualifier("jugadorConverter")
	private JugadorConverter jugadorConverter;

	@Override
	public List<Jugador> getAll(){	
		return jugadorRepository.findAll();	
	}


	@Override
	public JugadorModelo insertOrUpdate(JugadorModelo jugadorModelo) {

		Jugador jugador = jugadorRepository.save(jugadorConverter.modelToEntity(jugadorModelo));

		return jugadorConverter.entityToModel(jugador);
	}

	@Override
	public boolean remove(int id) {

		try {
			jugadorRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}

	}

}
