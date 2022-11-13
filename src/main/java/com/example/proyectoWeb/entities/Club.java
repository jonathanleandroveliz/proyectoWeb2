package com.example.proyectoWeb.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="club")
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="apodo")
	private String apodo;

	@Column(name="anio_fundacion")
	private int anio;
	
	@Column(name="presidente")
	private String presidente;
	
	@Column(name="imagen")
	private String imagen;
	
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tecnico_id", referencedColumnName = "id")
	private Tecnico tecnico;
	
	@OneToOne(mappedBy = "club")
	private Manager manager; 
	
	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Jugador> jugador;
	
	public Club()
	{}

	public Club(int id, String nombre, String apodo, int anio, String presidente, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
	}
	
	
	
	public Club(int id, String nombre, String apodo, int anio, String presidente, String imagen, Tecnico tecnico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
		this.tecnico = tecnico;
	}
	
	

	public Club(int id, String nombre, String apodo, int anio, String presidente, String imagen, Tecnico tecnico,
			List<Jugador> jugador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
		this.tecnico = tecnico;
		this.jugador = jugador;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Jugador> getJugador() {
		return jugador;
	}

	public void setJugador(List<Jugador> jugador) {
		this.jugador = jugador;
	}

	public Club(int id, String nombre, String apodo, int anio, String presidente, String imagen, Tecnico tecnico,
			Manager manager, List<Jugador> jugador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.anio = anio;
		this.presidente = presidente;
		this.imagen = imagen;
		this.tecnico = tecnico;
		this.manager = manager;
		this.jugador = jugador;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
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
	
	
	
	

}
