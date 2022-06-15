package com.uni.newtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.newtp.entities.RolEntity;
import com.uni.newtp.entities.UserEntity;
import com.uni.newtp.repositories.UserRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	// Metodo para obtener el user y sus roles
	@Override
	@Transactional( readOnly=true )
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		
		// Buscamos el User en la BD
		UserEntity user = repo.findByDni(dni);
		
		// Verificamos que el User no sea null, sino lanza excepcion
		if( user == null ) throw new UsernameNotFoundException("Error: User not found");
		
		// Se crea una Lista GrantedAuthority para obtener los Roles del User
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		// Se recorren los Roles del User agregando cada Rol a la Lista
		for( RolEntity rol : user.getRoles() ) {
			roles.add(new SimpleGrantedAuthority(rol.getName()));
		}
		
		// Finalmente se retorna un Objeto tipo User (Importado de Spring Security)
		// Parametros: usuario, contraseña, roles
		return new User(user.getDni(), user.getPassword(), roles);
	}

}
