package com.example.proyectoWeb.converters;

import org.springframework.stereotype.Component;


import com.example.proyectoWeb.entities.Tecnico;
import com.example.proyectoWeb.models.TecnicoModelo;



@Component("tecnicoConverter")
public class TecnicoConverter {

	public TecnicoModelo entityToModel(Tecnico tecnico) {

		return new TecnicoModelo(tecnico.getId(),tecnico.getNombre(),tecnico.getApellido(),tecnico.getEdad(),
				tecnico.getPais(),tecnico.getImagen(),tecnico.getCantidad());

	}
	
	public Tecnico modelToEntity(TecnicoModelo tecnicoModelo) {

		return new Tecnico(tecnicoModelo.getId(),tecnicoModelo.getNombre(),tecnicoModelo.getApellido(),
				tecnicoModelo.getEdad(),tecnicoModelo.getPais(),tecnicoModelo.getImagen(),tecnicoModelo.getCantidad());

	}
	
}
