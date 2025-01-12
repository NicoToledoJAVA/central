/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.dto.JwtResponseDTO;
import ecomistika.central.utils.JwtUtils;

import ecomistika.central.dto.LoginRequestDTO;
import ecomistika.central.model.Owner;
import ecomistika.central.service.IOwnerService;
import ecomistika.central.service.OwnerService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class LoginController {

    
    
    @Autowired
    IOwnerService ownerService;
    
 @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    
    
    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }
    
    

    @PostMapping("/login")   

    @PreAuthorize("permitAll()")   

    
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
       try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUserName(),
                    loginRequest.getPasswordHash()
                )
            );

            String token = jwtUtils.createToken(authentication);
            return ResponseEntity.ok(new JwtResponseDTO(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}

   //  @PreAuthorize("denyAll()")
