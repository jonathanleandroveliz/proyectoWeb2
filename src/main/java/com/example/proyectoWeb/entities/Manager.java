package com.example.proyectoWeb.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="manager")
public class Manager {
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "club_id", referencedColumnName = "id")
	private Club club; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Manager(){}
	
	public Manager(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Manager(Club club, int id, String nombre) {
		super();
		this.club = club;
		this.id = id;
		this.nombre = nombre;
	}
	
	

}
