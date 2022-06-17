package com.uni.newtp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.newtp.entities.MatterEntity;

public interface MatterRepository extends JpaRepository<MatterEntity, Long>{
}

