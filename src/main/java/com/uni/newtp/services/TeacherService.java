package com.uni.newtp.services;

import java.util.List;

import com.uni.newtp.entities.TeacherEntity;

public interface TeacherService{
	public TeacherEntity getOne(Long id);
	public List<TeacherEntity> getAll();
	public void save(TeacherEntity teacher);
	public void delete(TeacherEntity teacher);
}
