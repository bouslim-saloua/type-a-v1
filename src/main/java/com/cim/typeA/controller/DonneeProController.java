/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.DonneePro;
import com.cim.typeA.service.DonneeProService;
import java.util.List;
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

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("api/donneePro")
@AllArgsConstructor
public class DonneeProController {
    
final DonneeProService donneeProService;


@PostMapping("/save")
public ResponseEntity<?> save(@RequestBody DonneePro donneePro) throws Exception{
if(donneePro == null) return ResponseEntity.badRequest().body("La donneePro fourni n'est pas valide");
return ResponseEntity.status(HttpStatus.CREATED).body(donneeProService.save(donneePro));
}

@PutMapping("/update")
public ResponseEntity<?> update(@RequestBody DonneePro donneePro) throws Exception{
if(donneePro == null) return ResponseEntity.badRequest().body("La donneePro fourni n'est pas valide");
return ResponseEntity.ok().body(donneeProService.update(donneePro));
}

@GetMapping("/donneePros")
public ResponseEntity<?> findAll(){
return ResponseEntity.ok().body(donneeProService.findAll());
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
if(id == null ) return ResponseEntity.badRequest().body("L'identifiant fourni n'est pas valide");

return ResponseEntity.ok().body("La donneePro [ " + donneeProService.delete(id) +" est supprimé avec success");
}




}
