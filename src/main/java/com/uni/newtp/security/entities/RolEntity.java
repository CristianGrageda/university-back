package com.uni.newtp.security.entities;

import javax.persistence.*;

import com.uni.newtp.security.enums.RolName;

@Entity
public class RolEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private RolName rolName;

	public RolEntity() {
    }
	public RolEntity(RolName rolName) {
		this.rolName = rolName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RolName getRolName() {
		return rolName;
	}
	public void setRolName(RolName rolName) {
		this.rolName = rolName;
	}
}
