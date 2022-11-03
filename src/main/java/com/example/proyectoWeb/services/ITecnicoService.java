package com.example.proyectoWeb.services;

import java.util.List;

import com.example.proyectoWeb.entities.Tecnico;
import com.example.proyectoWeb.models.TecnicoModelo;



public interface ITecnicoService {

	public List<Tecnico> getAll();

	public TecnicoModelo insertOrUpdate(TecnicoModelo tecnicoModelo);

	public boolean remove(int id);
}
