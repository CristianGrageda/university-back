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

import com.uni.newtp.entities.TeacherEntity;
import com.uni.newtp.services.impl.TeacherServiceImpl;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
	@Autowired
	private TeacherServiceImpl teacherService;
	
	/******* Get All Teachers *******/
	@GetMapping( value = "/" )
	public List<TeacherEntity> list(){
		List<TeacherEntity> listResult = teacherService.getAll();
		return listResult;
	}
	
	/******* Get One Teacher *******/
	@GetMapping( value = "/{id}" )
	public TeacherEntity getTeacher(@PathVariable Long id){
		TeacherEntity getResult = teacherService.getOne(id);
		return getResult;
	}
	
	/******* Save Teacher *******/
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping( value = "/" )
	public void add(@RequestBody TeacherEntity teacher) {
		teacherService.save(teacher);
	}
	
	/******* Save Teacher *******/
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping( value = "/" )
	public void delete(@RequestBody TeacherEntity teacher) {
		teacherService.delete(teacher);
	}
}
