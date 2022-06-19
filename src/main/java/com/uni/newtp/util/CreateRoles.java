/*package com.uni.newtp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uni.newtp.security.entities.RolEntity;
import com.uni.newtp.security.enums.RolName;
import com.uni.newtp.security.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner {
	
	@Autowired
	RolService rolService;

	@Override
	public void run(String... args) throws Exception {
		RolEntity rolAdmin = new RolEntity(RolName.ROLE_ADMIN);
		RolEntity rolUser = new RolEntity(RolName.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
	}

}
*/