package com.example.proyectoWeb.repositories;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.proyectoWeb.entities.User;
import com.example.proyectoWeb.models.UsuarioModelo;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {

	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = (:username)")
	public abstract User findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);

	public abstract com.example.proyectoWeb.entities.User  save(
			com.example.proyectoWeb.entities.User modelToEntity);


}