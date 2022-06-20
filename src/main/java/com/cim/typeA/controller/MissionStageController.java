/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;


import com.cim.typeA.exception.ResourceNotFoundException;
import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.MissionStage;
import com.cim.typeA.model.MissionStage;
import com.cim.typeA.model.Soutien;
import com.cim.typeA.payload.holder.MissionStageHolder;
import com.cim.typeA.repository.DemandeurRepository;
import com.cim.typeA.repository.MissionStageRepository;
import com.cim.typeA.service.MissionStageService;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
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
@RequestMapping("api/mission")
@AllArgsConstructor
public class MissionStageController {

final MissionStageService missionStageService;
final DemandeurRepository demandeurRepository;
final MissionStageRepository missionStageRepository;


@PostMapping("/")
public ResponseEntity<?> save( @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.status(HttpStatus.CREATED).body(missionStageService.save(missionStage));
}

@PutMapping("/update")
public ResponseEntity<?> update( @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.ok().body(missionStageService.update(missionStage));
}


//update
@PutMapping("/valider")
public ResponseEntity<?> valider( @RequestBody MissionStage missionStage) throws Exception{
if(missionStage == null) return ResponseEntity.badRequest().body("La missionStage fourni n'est pas valide");
return ResponseEntity.ok().body(missionStageService.valider(missionStage));
}

@PutMapping("/refuser")
public ResponseEntity<?> refuser( @RequestBody MissionStage missionStage) throws Exception{
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

/*@GetMapping("/History")
public ResponseEntity<?> findAllByDateCreation(){
return ResponseEntity.ok().body(missionStageService.findAllByDateCreation());
}*/

/*@PostMapping("/{userId}/")
public ResponseEntity<?> addMissionStage(@PathVariable Long userId,  @RequestBody MissionStageHolder missionStageHolder) {
//return ResponseEntity.ok().body(manifestationService.addMissionStage(userId, donneePro, manifestation, soutien));
MissionStage missionStage = missionStageHolder.getMissionStage();
DonneePro donneePro = missionStageHolder.getDonneePro();
Soutien soutien = missionStageHolder.getSoutien();

MissionStage missionStageBD = demandeurRepository.findById(userId).map(demandeur->{
missionStage.setDemandeur(demandeur);
donneePro.setMissionStage(missionStage);
missionStage.setDonneePro(donneePro);
missionStage.setSoutien(soutien);
soutien.setMissionStage(missionStage);
return missionStageRepository.save(missionStage);
}).orElseThrow(() -> new ResourceNotFoundException("Not found demandeur with id = " + userId));
return new ResponseEntity<>(missionStage, HttpStatus.CREATED);
}*/

@PostMapping("/save/{userId}")
public ResponseEntity<?> createMissionStage(@PathVariable Long userId, @RequestBody MissionStageHolder missionStageHolder) throws ParseException{
MissionStage missionStage = new MissionStage();
Soutien soutien  = new Soutien();
DonneePro donneePro = new DonneePro();
String dateC = missionStageHolder.getDateCreation();
 
    //    LocalDate dateCreation =  LocalDate.parse(dateC, DateTimeFormatter.ISO_DATE.ISO_DATE);
 Date dateCreation = new SimpleDateFormat("dd/MM/yyyy").parse(dateC);
missionStage.setDateCreation(dateCreation);
missionStage.setTitre(missionStageHolder.getTitre());
missionStage.setRespoMarocain(missionStageHolder.getRespoMarocain());
missionStage.setPartenaireEtranger(missionStageHolder.getPartenaireEtranger());
missionStage.setDateDebut(missionStageHolder.getDateDebut());
missionStage.setDateDepart(missionStageHolder.getDateDepart());
missionStage.setDateFin(missionStageHolder.getDateFin());
missionStage.setDateRetour(missionStageHolder.getDateRetour());
missionStage.setHasCurrentTypeA(missionStageHolder.getHasCurrentTypeA());
missionStage.setCadreSoutien(missionStageHolder.getCadreSoutien());
missionStage.setStatus(missionStageHolder.getStatus());
missionStage.setPays(missionStageHolder.getPays());
missionStage.setVille(missionStageHolder.getVille());
missionStage.setObjet(missionStageHolder.getObjet());
missionStage.setMontantAnEnCours(missionStageHolder.getMontantAnEnCours());
missionStage.setMontantAnPrd(missionStageHolder.getMontantAnPrd());
//DonneePro
donneePro.setAnneeThese(missionStageHolder.getAnneeThese());
donneePro.setCed(missionStageHolder.getCed());
donneePro.setDepartement(missionStageHolder.getDepartement());
donneePro.setDirecteurThese(missionStageHolder.getDirecteurThese());
donneePro.setEntiteRecherche(missionStageHolder.getEntiteRecherche());
donneePro.setEtablissement(missionStageHolder.getEtablissement());
donneePro.setFonctionnalite(missionStageHolder.getFonctionnalite());
donneePro.setGrade(missionStageHolder.getGrade());
donneePro.setRespoEntite(missionStageHolder.getRespoEntite());
donneePro.setSalarie(missionStageHolder.getSalarie());

//soutien

soutien.setNature(missionStageHolder.getNature());
soutien.setMTitreTransport(missionStageHolder.getMTitreTransport());
soutien.setMHebergement(missionStageHolder.getMHebergement());
soutien.setMFraisInscription(missionStageHolder.getMFraisInscription());
soutien.setMAutre(missionStageHolder.getMAutre());


MissionStage missionBD = demandeurRepository.findById(userId).map(demandeur->{
missionStage.setDemandeur(demandeur);
donneePro.setMissionStage(missionStage);
missionStage.setDonneePro(donneePro);
missionStage.setSoutien(soutien);
soutien.setMissionStage(missionStage);
return missionStageRepository.save(missionStage);
}).orElseThrow(() -> new ResourceNotFoundException("Not found demandeur with id = " + userId));
return new ResponseEntity<>(missionStage, HttpStatus.CREATED);

}

@GetMapping("/missionsByUser/{utilisateurId}")
public List<MissionStage> findAllByUtilisateurId(@PathVariable Long utilisateurId){
return missionStageService.findAllByUtilisateurId(utilisateurId);
}
}
