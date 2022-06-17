package com.uni.newtp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uni.newtp.entities.TeacherEntity;
import com.uni.newtp.services.impl.TeacherServiceImpl;

@RestController
public class TeacherController {
	@Autowired
	private TeacherServiceImpl teacherService;
	
	/******* Get All Teachers *******/
	@GetMapping( value = "/teacher" )
	public List<TeacherEntity> list(){
		List<TeacherEntity> listResult = teacherService.getAll();
		return listResult;
	}
	
	/******* Get All Teachers *******/
	@GetMapping( value = "/teacher/{id}" )
	public TeacherEntity getTeacher(@PathVariable Long id){
		TeacherEntity getResult = teacherService.getOne(id);
		return getResult;
	}
}