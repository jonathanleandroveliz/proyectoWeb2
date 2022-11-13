package com.example.proyectoWeb.models;

public class ManagerModelo {
	
	private int id;
	
	private int nombre;
	
	private ClubModelo clubModelo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public ClubModelo getClubModelo() {
		return clubModelo;
	}

	public void setClubModelo(ClubModelo clubModelo) {
		this.clubModelo = clubModelo;
	}
	
	public ManagerModelo() {}
	
	public ManagerModelo(int id, int nombre, ClubModelo clubModelo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clubModelo = clubModelo;
	}

	@Override
	public String toString() {
		return "ManagerModelo [id=" + id + ", nombre=" + nombre + ", clubModelo=" + clubModelo + "]";
	}



}
