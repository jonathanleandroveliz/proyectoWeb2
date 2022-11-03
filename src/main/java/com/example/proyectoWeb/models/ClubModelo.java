package com.example.proyectoWeb.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class ClubModelo {
	
	private int id;

	private String nombre;

	private String apodo;

	private int anio;

	private String presidente;

	private String imagen;
	
	private TecnicoModelo tecnicomodelo;
	
	public ClubModelo() 
	{}
	
	
	
	public ClubModelo(int id, String nombre, String apodo, int anio, String presidente, String imagen,
			TecnicoModelo tecnicomodelo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
		this.tecnicomodelo = tecnicomodelo;
	}



	public ClubModelo(String nombre, String apodo, int anio, String presidente, String imagen) {
		super();
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
	}



	public ClubModelo(int id, String nombre, String apodo, int anio, String presidente, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
	}

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

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	public TecnicoModelo getTecnicomodelo() {
		return tecnicomodelo;
	}




	public void setTecnicomodelo(TecnicoModelo tecnicomodelo) {
		this.tecnicomodelo = tecnicomodelo;
	}



	@Override
	public String toString() {
		return "ClubModelo [id=" + id + ", nombre=" + nombre + ", apodo=" + apodo + ", anio=" + anio + ", presidente="
				+ presidente + ", imagen=" + imagen + ", tecnicomodelo=" + tecnicomodelo + "]";
	}




	

}
