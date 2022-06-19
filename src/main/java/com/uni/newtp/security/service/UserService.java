package com.uni.newtp.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.newtp.security.entities.UserEntity;
import com.uni.newtp.security.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<UserEntity> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(UserEntity usuario){
    	userRepository.save(usuario);
    }
}
