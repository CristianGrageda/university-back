package com.uni.newtp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordCrypt {

	public static void main(String[] args) {
		String pass = "9999";
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		System.out.println(pass);
		System.out.println(encode.encode(pass));
	}

}
