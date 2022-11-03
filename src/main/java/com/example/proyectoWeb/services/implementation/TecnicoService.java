package com.example.proyectoWeb.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyectoWeb.converters.TecnicoConverter;
import com.example.proyectoWeb.entities.Tecnico;
import com.example.proyectoWeb.models.TecnicoModelo;
import com.example.proyectoWeb.repositories.ITecnicoRepository;
import com.example.proyectoWeb.services.ITecnicoService;


@Service("tecnicoService")
public class TecnicoService implements ITecnicoService {
	
	@Autowired
	@Qualifier("tecnicoRepository")
	private ITecnicoRepository tecnicoRepository;

	@Autowired
	@Qualifier("tecnicoConverter")
	private TecnicoConverter tecnicoConverter;
	
	@Override
	public List<Tecnico> getAll(){	
		return tecnicoRepository.findAll();	
	}

	@Override
	public TecnicoModelo insertOrUpdate(TecnicoModelo tecnicoModelo) {

		Tecnico tecnico = tecnicoRepository.save(tecnicoConverter.modelToEntity(tecnicoModelo));

		return tecnicoConverter.entityToModel(tecnico);
	}
	
	@Override
	public boolean remove(int id) {

		try {
			tecnicoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}

	}

	
}
