/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.converter.impl.UtilisateurGetDtoConverter;
import com.cim.typeA.converter.impl.UtilisateurPostConverter;
import com.cim.typeA.dto.UtilisateurGetDto;
import com.cim.typeA.dto.UtilisateurPostDto;


import com.cim.typeA.service.UtilisateurService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@Api("Cette end-point permet de gerer les utilisateurs")
@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurController {

final UtilisateurService utilisateurService;
final UtilisateurPostConverter utilisateurPostConverter;
final UtilisateurGetDtoConverter utilisateurGetDtoConverter;

public UtilisateurController(UtilisateurService utilisateurService,  UtilisateurPostConverter utilisateurPostConverter,  UtilisateurGetDtoConverter utilisateurGetDtoConverter){
this.utilisateurService = utilisateurService;
 this.utilisateurGetDtoConverter =utilisateurGetDtoConverter;
this.utilisateurPostConverter =utilisateurPostConverter;
}


@PostMapping("/")
public ResponseEntity<?> save(@Valid @RequestBody UtilisateurPostDto utilisateurPostDto) throws Exception {
if(utilisateurPostDto == null) 
return ResponseEntity.badRequest().body("L'utilisateur fourni n'est pas valid");
 return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurGetDtoConverter.convertToDTO(utilisateurService.save(utilisateurPostDto)));
}

@PutMapping("/")
public ResponseEntity<?> update(@Valid @RequestBody UtilisateurPostDto utilisateurPostDto)throws Exception{
if(utilisateurPostDto == null) 
return ResponseEntity.badRequest().body("L'utilisateur fourni n'est pas valid");
return ResponseEntity.ok().body(utilisateurGetDtoConverter.convertToDTO(utilisateurService.update(utilisateurPostDto)));
}


@DeleteMapping("/id/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
if(id == null ) return ResponseEntity.badRequest().body("L'identifiant fourni n'est pas valide");

return ResponseEntity.ok().body("L'utilisateur [ " + utilisateurService.delete(id) +" est supprimé avec success");
}

@GetMapping("/")
public ResponseEntity<List<UtilisateurGetDto>> findAll(){
return ResponseEntity.ok().body(utilisateurService.findAll());
}

@GetMapping("/email/{email}")
public ResponseEntity<?> findByEmail(@PathVariable String email){
return ResponseEntity.ok().body(utilisateurService.findByEmail(email));
}

@GetMapping("/telephone/{telephone}")
public ResponseEntity<?> findByTelehone(@PathVariable String telephone){
return ResponseEntity.ok().body(utilisateurService.findByTelephone(telephone));
}

@PostMapping("/signUp/")
public ResponseEntity<?> signUp(@Valid @RequestBody UtilisateurPostDto utilisateurPostDto) throws Exception{
return ResponseEntity.ok().body(utilisateurService.signUp(utilisateurPostDto));
}

@PostMapping("/signIn/")
public ResponseEntity<?> singIn(@Valid @RequestBody UtilisateurPostDto utilisateurPostDto) throws Exception{
return ResponseEntity.ok().body(utilisateurService.signIn(utilisateurPostDto));
}
    

}
