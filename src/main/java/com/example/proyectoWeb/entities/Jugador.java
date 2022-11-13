package com.example.proyectoWeb.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="jugador")
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="apellido")
	private String apellido;

	@Column(name="edad")
	private int edad;
	
	@Column(name="pais")
	private String pais;

	@Column(name="posicion")
	private String posicion;
	
	@Column(name="categoria")
	private String categoria;

	@Column(name="imagen")
	private String imagen;
	
	@Column(name="valuacion")
	private int valuacion;
	
	@ManyToOne
	@JoinColumn(name = "club_id")
	private Club club;

	
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	
	public Jugador()
	{}
	
	
	
	public Jugador(int id, String nombre, String apellido, int edad, String pais, String posicion, String categoria,
			String imagen, int valuacion, Club club) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.posicion = posicion;
		this.categoria = categoria;
		this.imagen = imagen;
		this.valuacion = valuacion;
		this.club = club;
	}



	public Jugador(int id, String nombre, String apellido, int edad, String pais, String posicion, String categoria,
			String imagen, int valuacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.posicion = posicion;
		this.categoria = categoria;
		this.imagen = imagen;
		this.valuacion = valuacion;
	}

	

	public Jugador(String nombre, String apellido, int edad, String pais, String categoria, String imagen) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.categoria = categoria;
		this.imagen = imagen;
	}



	public Jugador(int id, String nombre, String apellido, int edad, String pais, String posicion, String categoria,
			String imagen, int valuacion, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.posicion = posicion;
		this.categoria = categoria;
		this.imagen = imagen;
		this.valuacion = valuacion;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	


	public Jugador(int id, String nombre,String apellido, int edad, String pais, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.categoria = categoria;
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
	
	
	public Club getClub() {
		return club;
	}



	public void setClub(Club club) {
		this.club = club;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
