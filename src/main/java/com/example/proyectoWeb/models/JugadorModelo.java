package com.example.proyectoWeb.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class JugadorModelo {

	private int id;
	
	@Size(min=3 , max=14)
	private String nombre;
	
	@Size(min=3 , max=14)
	private String apellido;
	
	@Min(0)
	private int edad;


	private String pais;
	

	private String posicion;
	

	private String categoria;
	

	private String imagen;
	
	@Min(0)
	@Max(100000000)
	private int valuacion;
	

	public JugadorModelo() 
	{}

	public JugadorModelo(int id,String nombre, String apellido,int edad, String pais, String posicion, String categoria,
			String imagen,int valuacion) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.posicion = posicion;
		this.categoria = categoria;
		this.imagen = imagen;
		this.valuacion = valuacion;
	}
	

	public JugadorModelo(int id, @Size(min = 3, max = 14) String nombre, @Size(min = 3, max = 14) String apellido,
			@Min(0) int edad, String pais, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.categoria = categoria;
	}
	
	

	public JugadorModelo(@Size(min = 3, max = 14) String nombre, @Size(min = 3, max = 14) String apellido,
			@Min(0) int edad, String pais) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
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

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getValuacion() {
		return valuacion;
	}

	public void setValuacion(int valuacion) {
		this.valuacion = valuacion;
	}

	@Override
	public String toString() {
		return "JugadorModelo [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", pais=" + pais + ", posicion=" + posicion + ", categoria=" + categoria + ", imagen=" + imagen
				+ ", valuacion=" + valuacion + "]";
	}


	
	
}
