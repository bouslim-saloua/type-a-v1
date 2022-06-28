/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.model.MissionStage;
import com.cim.typeA.model.Soutien;
import com.cim.typeA.model.Soutien;
import com.cim.typeA.model.Utilisateur;
import com.cim.typeA.payload.holder.SoutienHolder;
import com.cim.typeA.repository.SoutienRepository;
import com.cim.typeA.service.SoutienService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@CrossOrigin(origins={"http://localhost:3000/","http://localhost:5000/"})
@RestController
@RequestMapping("api/soutien")
@AllArgsConstructor
public class SoutienController {

final SoutienService soutienService;
final SoutienRepository soutienRepository;
@PostMapping("/save")
public ResponseEntity<?> save(@RequestBody Soutien soutien) throws Exception{
if(soutien == null) return ResponseEntity.badRequest().body("La soutien fourni n'est pas valide");
return ResponseEntity.status(HttpStatus.CREATED).body(soutienService.save(soutien));
}



@GetMapping("/soutiens")
public ResponseEntity<?> findAll(){
return ResponseEntity.ok().body(soutienService.findAll());
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
if(id == null ) return ResponseEntity.badRequest().body("L'identifiant fourni n'est pas valide");

return ResponseEntity.ok().body("La soutien [ " + soutienService.delete(id) +" est supprimé avec success");
}

@GetMapping("/cTotal")
public ResponseEntity<?> calculerTotal( @RequestBody Soutien soutien) throws Exception{
if(soutien == null) return ResponseEntity.badRequest().body("La soutien fourni n'est pas valide");
return ResponseEntity.ok().body(soutienService.calculerTotal(soutien));
}

@GetMapping("/sommeTotal")
public ResponseEntity<?> findSumTotalSoutien(){
return ResponseEntity.ok().body(soutienService.findSumTotalSoutien());
}

@PutMapping("/modifier")
public Soutien modifier(@RequestBody SoutienHolder soutienHolder){
Soutien soutien = soutienRepository.findById(soutienHolder.getId()).orElse(null);
soutien.setMAutre(soutienHolder.getMAutre());
soutien.setMFraisInscription(soutienHolder.getMFraisInscription());
soutien.setMHebergement(soutienHolder.getMHebergement());
soutien.setMTitreTransport(soutienHolder.getMTitreTransport());
return soutienRepository.save(soutien);
}
}
