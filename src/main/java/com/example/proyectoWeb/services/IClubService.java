package com.example.proyectoWeb.services;

import java.util.List;

import com.example.proyectoWeb.entities.Club;
import com.example.proyectoWeb.models.ClubModelo;

public interface IClubService {

	public List<Club> getAll();

	public ClubModelo insertOrUpdate(ClubModelo clubModelo);

	public boolean remove(int id);
}
