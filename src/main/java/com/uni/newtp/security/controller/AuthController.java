package com.uni.newtp.security.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.newtp.security.dto.JwtDTO;
import com.uni.newtp.security.dto.LoginUserDTO;
import com.uni.newtp.security.dto.NewUser;
import com.uni.newtp.security.entities.RolEntity;
import com.uni.newtp.security.entities.UserEntity;
import com.uni.newtp.security.enums.RolName;
import com.uni.newtp.security.jwt.JwtProvider;
import com.uni.newtp.security.service.RolService;
import com.uni.newtp.security.service.UserService;
import com.uni.newtp.util.Message;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/newUser")
    public ResponseEntity<?> newUser(@RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("ese email ya existe"), HttpStatus.BAD_REQUEST);
        UserEntity user =
                new UserEntity(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<RolEntity> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("usuario guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody LoginUserDTO loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
