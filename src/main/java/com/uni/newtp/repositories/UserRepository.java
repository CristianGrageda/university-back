package com.uni.newtp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.newtp.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByDni(String dni);
}
