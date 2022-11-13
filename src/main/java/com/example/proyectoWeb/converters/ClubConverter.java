package com.example.proyectoWeb.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.proyectoWeb.entities.Club;
import com.example.proyectoWeb.models.ClubModelo;


@Component("clubConverter")
public class ClubConverter {
	
	@Autowired
	@Qualifier("tecnicoConverter")
	private TecnicoConverter tecnicoConverter;
	
	public ClubModelo entityToModel(Club club) {

		return new ClubModelo(club.getId(),club.getNombre(), club.getApodo(), club.getAnio(), club.getPresidente()
				,club.getImagen(), tecnicoConverter.entityToModel(club.getTecnico()));
	}
	
	public Club modelToEntity(ClubModelo clubModelo) {

		return new Club(clubModelo.getId(), clubModelo.getNombre(), clubModelo.getApodo(),
				clubModelo.getAnio(),clubModelo.getPresidente(),clubModelo.getImagen(), tecnicoConverter.modelToEntity(clubModelo.getTecnicomodelo()));
	}

	
}
