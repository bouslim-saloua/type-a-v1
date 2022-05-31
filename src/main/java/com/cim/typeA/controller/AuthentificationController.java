/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.CustomUtilisateurDetails;
import com.cim.typeA.model.ERole;
import com.cim.typeA.model.Role;
import com.cim.typeA.model.Utilisateur;
import com.cim.typeA.payload.request.LoginRequest;
import com.cim.typeA.payload.request.SignupRequest;
import com.cim.typeA.payload.response.JwtResponse;
import com.cim.typeA.payload.response.MessageResponse;
import com.cim.typeA.repository.RoleRepository;
import com.cim.typeA.repository.UtilisateurRepository;
import com.cim.typeA.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author USER
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {
	@Autowired
	       AuthenticationManager authenticationManager;
	@Autowired
	       UtilisateurRepository userRepository;
	@Autowired
	       RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	       JwtUtils jwtUtils;


//signIn

@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		  CustomUtilisateurDetails userDetails = (CustomUtilisateurDetails) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
//String accessToken, Long id, String email, String nom, String prenom,String telephone ,List<String> roles
	// public JwtResponse(String accessToken, Long id, String email, String nom, String prenom,String telephone ,List<String> roles) {	
return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(),
userDetails.getNom(), userDetails.getPrenom(), userDetails.getTelephone(),roles));
	}

@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		//Error when email is already in use
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

            //Error when telephone is already in use!
if(userRepository.existsByTelephone(signUpRequest.getTelephone())){
return ResponseEntity.badRequest().body(new MessageResponse("Erorr: N° Telephone est déjà utilisé!"));
}
		// Create new user's account
		Utilisateur user = new Utilisateur( signUpRequest.getNom(), signUpRequest.getPrenom(),signUpRequest.getTelephone(), signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER);
					//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
							//.orElseThrow() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER);
							//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
    

}
