package com.uni.newtp.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.newtp.security.entities.RolEntity;
import com.uni.newtp.security.enums.RolName;
import com.uni.newtp.security.repository.RolRepository;

@Service
@Transactional
public class RolService {
	
	@Autowired
    RolRepository rolRepository;

    public Optional<RolEntity> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }

    public void save(RolEntity rol){
        rolRepository.save(rol);
    }
}
