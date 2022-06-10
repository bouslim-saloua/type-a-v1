/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.Administrateur;
import com.cim.typeA.model.CustomUtilisateurDetails;
import com.cim.typeA.model.Demandeur;
import com.cim.typeA.model.ERole;
import com.cim.typeA.model.Role;
import com.cim.typeA.payload.request.LoginRequest;
import com.cim.typeA.payload.request.SignupRequest;
import com.cim.typeA.payload.response.JwtResponse;
import com.cim.typeA.payload.response.MessageResponse;
import com.cim.typeA.repository.AdministrateurRepository;
import com.cim.typeA.repository.DemandeurRepository;
import com.cim.typeA.repository.RoleRepository;
import com.cim.typeA.repository.UtilisateurRepository;
import com.cim.typeA.security.JwtUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
//@CrossOrigin("http://localhost:3000/")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/demandeur/auth")
public class DemandeurAuthController {
@Autowired
UtilisateurRepository userRepository;
     @Autowired
	       AuthenticationManager authenticationManager;
	@Autowired
	       DemandeurRepository demandeurRepository;
	@Autowired
	       RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	       JwtUtils jwtUtils;


//signIn

@PostMapping("/signIn")
	public ResponseEntity<?> authenticateDemandeur(@Valid @RequestBody LoginRequest loginRequest) {
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
	public ResponseEntity<?> registerDemandeur(@Valid @RequestBody SignupRequest signUpRequest) {
		//Error when email is already in use
		if (demandeurRepository.existsByEmail(signUpRequest.getEmail()) || userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

            //Error when telephone is already in use!
if(demandeurRepository.existsByTelephone(signUpRequest.getTelephone()) || userRepository.existsByTelephone(signUpRequest.getTelephone())){
return ResponseEntity.badRequest().body(new MessageResponse("Erorr: N° Telephone est déjà utilisé!"));
}
		// Create new demandeur's account
		  Demandeur demandeur = new Demandeur( signUpRequest.getNom(), signUpRequest.getPrenom(),signUpRequest.getTelephone(), signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role adminRole = roleRepository.findByName(ERole.ROLE_USER);
//orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRole);
		}
		demandeur.setRoles(roles);
		demandeurRepository.save(demandeur);
		return ResponseEntity.ok(new MessageResponse("Account registered successfully!"));
	}
}
