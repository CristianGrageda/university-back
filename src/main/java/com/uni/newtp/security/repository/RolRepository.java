package com.uni.newtp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uni.newtp.security.entities.RolEntity;
import com.uni.newtp.security.enums.RolName;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long>{
	Optional<RolEntity> findByRolName(RolName rolName);
}
