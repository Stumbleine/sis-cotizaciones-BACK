package com.umss.dev.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.config.JWTUtil;
import com.umss.dev.output.AuthenticationRequest;
import com.umss.dev.output.AuthenticationResponse;
import com.umss.dev.service.PruebaUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PruebaUserService pruebaUserService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = pruebaUserService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
        	Collection<? extends GrantedAuthority> roles=userDetails.getAuthorities();
        	
        	//roles=(List<GrantedAuthority>) userDetails.getAuthorities();
            return new ResponseEntity<>(new AuthenticationResponse(jwt,roles,pruebaUserService.getIdUser(request.getUsername())), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
