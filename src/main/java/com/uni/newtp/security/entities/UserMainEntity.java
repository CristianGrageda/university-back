package com.uni.newtp.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserMainEntity implements UserDetails{
	private String name;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
	public UserMainEntity(String name, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserMainEntity build(UserEntity userEntity) {
		List<GrantedAuthority> authorities =
				userEntity.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolName().name())).collect(Collectors.toList());
        return new UserMainEntity(userEntity.getName(), userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
