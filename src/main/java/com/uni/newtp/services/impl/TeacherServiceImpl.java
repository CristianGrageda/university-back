package com.uni.newtp.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.newtp.entities.TeacherEntity;
import com.uni.newtp.repositories.TeacherRepository;
import com.uni.newtp.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository repo;

	@Override
	@Transactional( readOnly = true )
	public TeacherEntity getOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	@Transactional( readOnly = true )
	public List<TeacherEntity> getAll() {
		return (List<TeacherEntity>) repo.findAll();
	}

	@Override
	@Transactional
	public void save(TeacherEntity teacher) {
		repo.save(teacher);
	}

	@Override
	@Transactional
	public void delete(TeacherEntity teacher) {
		repo.delete(teacher);
	}

}
