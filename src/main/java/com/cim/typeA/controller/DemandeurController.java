/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.Demandeur;
import com.cim.typeA.service.impl.DemandeurServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("api/demandeur")
public class DemandeurController {

@Autowired
private DemandeurServiceImpl demandeurService;


@GetMapping("/listes")
public List<Demandeur> findAll(){
return demandeurService.findAll();
}

@PostMapping("/addDemandeur")
public Demandeur save(@RequestBody Demandeur demandeur){
return demandeurService.save(demandeur);
}


   

}
