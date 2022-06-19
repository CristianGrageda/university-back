package com.uni.newtp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uni.newtp.security.entities.UserEntity;
import com.uni.newtp.security.entities.UserMainEntity;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userService.getByUsername(username).get();
        return UserMainEntity.build(userEntity);
	}

}
