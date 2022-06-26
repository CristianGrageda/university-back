package com.uni.newtp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.newtp.entities.MatterEntity;
import com.uni.newtp.services.impl.MatterServiceImpl;

@RestController
@RequestMapping("/matter")
@CrossOrigin
public class MatterController {
	@Autowired
	private MatterServiceImpl matterService;
	
	/******* Get All Matters *******/
	@GetMapping( value = "/" )
	public List<MatterEntity> list(){
		List<MatterEntity> listResult = matterService.getAll();
		return listResult;
	}
	
	/******* Get One Matter *******/
	@GetMapping( value = "/{id}" )
	public MatterEntity getMatter(@PathVariable Long id){
		MatterEntity getResult = matterService.getOne(id);
		return getResult;
	}
	
	/******* Save Matter *******/
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping( value = "/" )
	public void add(@RequestBody MatterEntity matter) {
		matterService.save(matter);
	}
	/******* Save Matter *******/
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping( value = "/" )
	public void delete(@RequestBody MatterEntity matter) {
		matterService.delete(matter);
	}
}
