package com.uni.newtp.services;

import java.util.List;

import com.uni.newtp.entities.MatterEntity;

public interface MatterService{
	public MatterEntity getOne(Long id);
	public List<MatterEntity> getAll();
	public void save(MatterEntity matter);
	public void delete(MatterEntity matter);
}
