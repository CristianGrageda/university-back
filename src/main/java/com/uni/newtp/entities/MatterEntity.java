package com.uni.newtp.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table( name = "matter" )
public class MatterEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "name" )
	private String name;
	
	@Column( name = "schedule" )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate schedule;
	
	@Column( name = "number_max_students" )
	private int numberMaxStudents;

}
