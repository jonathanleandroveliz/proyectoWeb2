package com.example.proyectoWeb.services;

import java.util.List;


import com.example.proyectoWeb.entities.Jugador;
import com.example.proyectoWeb.models.JugadorModelo;
public interface IJugadorService {

	public List<Jugador> getAll();

	public JugadorModelo insertOrUpdate(JugadorModelo jugadorModelo);

	public boolean remove(int id);
	
	public List<JugadorModelo> getAllModel();
	
	public JugadorModelo traerPorId(int id);
}
