package com.example.proyectoWeb.converters;


import org.springframework.stereotype.Component;


import org.springframework.security.core.userdetails.User;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.example.proyectoWeb.models.UsuarioModelo;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModelo entityToModel(User user) {

		return new UsuarioModelo(0,user.getUsername(),user.getPassword());

	}
	
	public User modelToEntity(UsuarioModelo usuarioModelo) {

		return new User(usuarioModelo.getUsername(), usuarioModelo.getPassword(), true,
				true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
				null);

	}
	

}
