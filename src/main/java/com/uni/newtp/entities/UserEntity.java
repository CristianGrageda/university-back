package com.uni.newtp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table( name = "user" )
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column( name = "dni" )
	private String dni;
	@Column( name = "password" )
	private String password;
	
	@OneToMany
	@JoinColumn(name="id_user")
	private List<RolEntity> roles = new ArrayList<RolEntity>();
}
