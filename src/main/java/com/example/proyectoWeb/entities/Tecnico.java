package com.example.proyectoWeb.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="tecnico")
public class Tecnico {
	
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
	
	@Column(name="imagen")
	private String imagen;
	
	@Column(name="cantidad_titulos")
	private int cantidad;
	
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToOne(mappedBy = "tecnico")
	private Club club;
	
	public Tecnico()
	{}

	public Tecnico(int id, String nombre, String apellido, int edad, String pais, String imagen, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.imagen = imagen;
		this.cantidad = cantidad;
	}

	

	public Tecnico(int id, String nombre, String apellido, int edad, String pais, String imagen, int cantidad,
			Club club) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.imagen = imagen;
		this.cantidad = cantidad;
		this.club = club;
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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	
	
	
}
