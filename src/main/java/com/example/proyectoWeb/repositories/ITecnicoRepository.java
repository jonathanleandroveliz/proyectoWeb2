package com.example.proyectoWeb.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.proyectoWeb.entities.Tecnico;



@Repository("tecnicoRepository")
public interface ITecnicoRepository extends 
JpaRepository<Tecnico, Serializable> {
	
	public abstract Tecnico findByid(int id);
	
	public abstract Tecnico findByNombre(String nombre);


	public abstract Tecnico findByPaisAndEdad(String pais, int edad);


	public abstract Tecnico findByPaisAndEdadOrderByEdadDesc(String pais, int edad);

}
