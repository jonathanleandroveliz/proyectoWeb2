package com.example.proyectoWeb.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class TecnicoModelo {
	
	private int id;

	private String nombre;

	private String apellido;

	private int edad;

	private String pais;

	private String imagen;

	private int cantidad;
	
	private ClubModelo clubmodelo;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	public ClubModelo getClubmodelo() {
		return clubmodelo;
	}

	public void setClubmodelo(ClubModelo clubmodelo) {
		this.clubmodelo = clubmodelo;
	}

	public TecnicoModelo()
	{}
	

	public TecnicoModelo(int id, String nombre, String apellido, int edad, String pais, String imagen, int cantidad,
			ClubModelo clubmodelo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.imagen = imagen;
		this.cantidad = cantidad;
		this.clubmodelo = clubmodelo;
	}

	public TecnicoModelo(int id, String nombre, String apellido, int edad, String pais, String imagen, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.imagen = imagen;
		this.cantidad = cantidad;
	}

	public TecnicoModelo(String nombre, String apellido, int edad, String pais, String imagen, int cantidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.imagen = imagen;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "TecnicoModelo [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", pais=" + pais
				+ ", imagen=" + imagen + ", cantidad=" + cantidad + "]";
	}	
	
	
	
}
