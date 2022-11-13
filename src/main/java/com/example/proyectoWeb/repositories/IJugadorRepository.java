package com.example.proyectoWeb.repositories;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.proyectoWeb.entities.Jugador;

@Repository("jugadorRepository")
public interface IJugadorRepository extends 
JpaRepository<Jugador, Serializable> {

	public abstract Jugador findByNombre(String nombre);
	
	public abstract Jugador findById(int id);


	public abstract Jugador findByPaisAndEdad(String pais, int edad);


	public abstract Jugador findByPaisAndEdadOrderByEdadDesc(String pais, int edad);
	
}
