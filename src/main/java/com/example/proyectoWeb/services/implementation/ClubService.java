package com.example.proyectoWeb.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyectoWeb.converters.ClubConverter;
import com.example.proyectoWeb.entities.Club;
import com.example.proyectoWeb.models.ClubModelo;
import com.example.proyectoWeb.repositories.IClubRepository;
import com.example.proyectoWeb.services.IClubService;




@Service("clubService")
public class ClubService implements IClubService {

	@Autowired
	@Qualifier("clubRepository")
	private IClubRepository clubRepository;
	
	@Autowired
	@Qualifier("clubConverter")
	private ClubConverter clubConverter;

	
	@Override
	public List<Club> getAll(){	
		return clubRepository.findAll();	
	}


	@Override
	public ClubModelo insertOrUpdate(ClubModelo clubModelo) {

		Club club = clubRepository.save(clubConverter.modelToEntity(clubModelo));

		return clubConverter.entityToModel(club);
	}

	@Override
	public boolean remove(int id) {

		try {
			clubRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
