package com.example.proyectoWeb.models.request;
import com.fasterxml.jackson.annotation.JsonProperty;

	public class JugadorRequest {
		
		@JsonProperty("Nombre")
		private String nombre;
		
		@JsonProperty("Edad")
		private int edad;
		
		@JsonProperty("Apellido")
		private String apellido;
		
		@JsonProperty("Pais")
		private String pais;
		
		@JsonProperty("Categoria")
		private String categoria;
		
		@JsonProperty("Posicion")
		private String posicion;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String getPosicion() {
			return posicion;
		}

		public void setPosicion(String posicion) {
			this.posicion = posicion;
		}

		public JugadorRequest(String nombre, int edad, String apellido, String pais, String categoria, String posicion) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.apellido = apellido;
			this.pais = pais;
			this.categoria = categoria;
			this.posicion = posicion;
		}
		
		public JugadorRequest() {}

		@Override
		public String toString() {
			return "JugadorRequest [nombre=" + nombre + ", edad=" + edad + ", apellido=" + apellido + ", pais=" + pais
					+ ", categoria=" + categoria + ", posicion=" + posicion + "]";
		}
		
		
	
}
