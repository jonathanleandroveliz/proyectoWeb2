package com.example.proyectoWeb.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyectoWeb.entities.Club;

@Repository("clubRepository")
public interface IClubRepository extends 
				JpaRepository<Club, Serializable> {
	
	public abstract Club findByNombre(String nombre);

}
