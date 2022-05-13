/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.MissionStage;
import com.cim.typeA.model.MissionStage;
import com.cim.typeA.service.MissionStageService;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("api/mission")
@AllArgsConstructor
public class MissionStageController {

final MissionStageService missionStageService;


@PostMapping("/")
public ResponseEntity<?> save(@Valid @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.status(HttpStatus.CREATED).body(missionStageService.save(missionStage));
}

@PutMapping("/update")
public ResponseEntity<?> update(@Valid @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.ok().body(missionStageService.update(missionStage));
}


//update
@PutMapping("/valider")
public ResponseEntity<?> valider(@Valid @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.ok().body(missionStageService.valider(missionStage));
}

@PutMapping("/refuser")
public ResponseEntity<?> refuser(@Valid @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.ok().body(missionStageService.refuser(missionStage));
}

@GetMapping("/missionStages")
public ResponseEntity<?> findAll(){
return ResponseEntity.ok().body(missionStageService.findAll());
}

@GetMapping("/allRefused")
public ResponseEntity<?> findAllRefused(){
return ResponseEntity.ok().body(missionStageService.findAllRefused());
}

@GetMapping("/allAccepted")
public ResponseEntity<?> findAllAccepted(){
return ResponseEntity.ok().body(missionStageService.findAllAccepted());
}

@GetMapping("/allInProgress")
public ResponseEntity<?> findAllInProgress(){
return ResponseEntity.ok().body(missionStageService.findAllInProgress());
}

@GetMapping("/countAll")
public ResponseEntity<?> countAll(){
return ResponseEntity.ok().body(missionStageService.countAll());
}

@GetMapping("/cAllRefused")
public ResponseEntity<?> countAllRefused(){
return ResponseEntity.ok().body(missionStageService.countAllRefused());
}

@GetMapping("/cAllAccepted")
public ResponseEntity<?> countAllAccepted(){
return ResponseEntity.ok().body(missionStageService.countAllAccepted());
}

@GetMapping("cAllInProgress")
public ResponseEntity<?> countAllInProgress(){
return ResponseEntity.ok().body(missionStageService.countAllInProgress());
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
if(id == null ) return ResponseEntity.badRequest().body("L'identifiant fourni n'est pas valide");

return ResponseEntity.ok().body("La missionStage [ " + missionStageService.delete(id) +" est supprimé avec success");
}

 @GetMapping("/id/{id}")
 public void generateReport(@PathVariable Long id, HttpServletResponse response) throws IOException, JRException, SQLException {
response.setContentType("application/x-download");

 response.setHeader("Content-Disposition", String.format("attachment; filename=\"mission_stage.pdf\""));
OutputStream out = response.getOutputStream();
missionStageService.exportPdfFile(id, out);
}



}
