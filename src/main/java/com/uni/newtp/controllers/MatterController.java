package com.uni.newtp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uni.newtp.entities.MatterEntity;
import com.uni.newtp.services.impl.MatterServiceImpl;

@RestController
public class MatterController {
	
	@Autowired
	private MatterServiceImpl matterService;
	
	@GetMapping( value = "/matter" )
	public List<MatterEntity> list(){
		List<MatterEntity> listResult = matterService.getAll();
		return listResult;
	}
	
	@GetMapping( value = "/matter/{id}" )
	public MatterEntity getMatter(@PathVariable Long id){
		MatterEntity getResult = matterService.getOne(id);
		return getResult;
	}
	
}
