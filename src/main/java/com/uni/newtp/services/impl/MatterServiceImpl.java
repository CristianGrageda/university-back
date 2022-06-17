package com.uni.newtp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.newtp.entities.MatterEntity;
import com.uni.newtp.repositories.MatterRepository;
import com.uni.newtp.services.MatterService;

@Service
public class MatterServiceImpl implements MatterService{
	
	@Autowired
	private MatterRepository repo;

	@Override
	@Transactional( readOnly = true )
	public MatterEntity getOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	@Transactional( readOnly = true )
	public List<MatterEntity> getAll() {
		return (List<MatterEntity>) repo.findAll();
	}

	@Override
	@Transactional
	public void save(MatterEntity matter) {
		repo.save(matter);
	}

	@Override
	@Transactional
	public void delete(MatterEntity matter) {
		repo.delete(matter);
	}

}
