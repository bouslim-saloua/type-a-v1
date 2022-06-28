/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.exception.ResourceNotFoundException;
import com.cim.typeA.model.Demandeur;
import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.model.Soutien;
import com.cim.typeA.payload.holder.ManifestationHolder;
import com.cim.typeA.payload.holder.ManifestationHolderResponse;
import com.cim.typeA.repository.DemandeurRepository;
import com.cim.typeA.repository.ManifestationRepository;
import com.cim.typeA.service.ManifestationService;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@CrossOrigin(origins={"http://localhost:3000/","http://localhost:5000/"})
@RestController
@RequestMapping("api/manifestation")
@AllArgsConstructor
public class ManifestationController {

final ManifestationService manifestationService;
final DemandeurRepository demandeurRepository;
final ManifestationRepository manifestationRepository;

@PostMapping("/enregistrer")
public ResponseEntity<?> save( @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.status(HttpStatus.CREATED).body(manifestationService.save(manifestation));
}

@PutMapping("/update")
public ResponseEntity<?> update( @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.update(manifestation));
}


//update
@PutMapping("/valider/{id}")
public ResponseEntity<?> valider( @PathVariable Long id) throws Exception{
if(id == null) return ResponseEntity.badRequest().body("L'id fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.valider(id));
}

@PutMapping("/refuser/{id}")
public ResponseEntity<?> refuser( @PathVariable Long id) throws Exception{
if(id == null) return ResponseEntity.badRequest().body("L'id fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.refuser(id));
}

@GetMapping("/manifestations")
public ResponseEntity<?> findAll(){
return ResponseEntity.ok().body(manifestationService.findAll());
}

@GetMapping("/allRefused")
public ResponseEntity<?> findAllRefused(){
return ResponseEntity.ok().body(manifestationService.findAllRefused());
}

@GetMapping("/allAccepted")
public ResponseEntity<?> findAllAccepted(){
return ResponseEntity.ok().body(manifestationService.findAllAccepted());
}

@GetMapping("/allInProgress")
public ResponseEntity<?> findAllInProgress(){
return ResponseEntity.ok().body(manifestationService.findAllInProgress());
}

@GetMapping("/countAll")
public ResponseEntity<?> countAll(){
return ResponseEntity.ok().body(manifestationService.countAll());
}

@GetMapping("/cAllRefused")
public ResponseEntity<?> countAllRefused(){
return ResponseEntity.ok().body(manifestationService.countAllRefused());
}

@GetMapping("/cAllAccepted")
public ResponseEntity<?> countAllAccepted(){
return ResponseEntity.ok().body(manifestationService.countAllAccepted());
}

@GetMapping("cAllInProgress")
public ResponseEntity<?> countAllInProgress(){
return ResponseEntity.ok().body(manifestationService.countAllInProgress());
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
if(id == null ) return ResponseEntity.badRequest().body("L'identifiant fourni n'est pas valide");

return ResponseEntity.ok().body("La manifestation [ " + manifestationService.delete(id) +" est supprimé avec success");
}

 @GetMapping({ "/", ""})
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();

  model.setViewName("home");
  return model;
 }

 @GetMapping("/id/{id}")
 public void generateReport(@PathVariable Long id, HttpServletResponse response) throws IOException, JRException, SQLException {
response.setContentType("application/x-download");

 response.setHeader("Content-Disposition", String.format("attachment; filename=\"manifestation.pdf\""));
OutputStream out = response.getOutputStream();
manifestationService.exportPdfFile(id, out);
}



@GetMapping("/manifestationsByUser/{utilisateurId}")
public List<Manifestation> findAllByUtilisateurId(@PathVariable Long utilisateurId) throws Exception{
return manifestationService.findAllByUtilisateurId(utilisateurId);
}



//Another try
@PostMapping("/{userId}")
public ResponseEntity<?> createManifestation(@PathVariable Long userId, @RequestBody ManifestationHolder manifestationHolder) throws ParseException{

String dateC = manifestationHolder.getDateCreation();
 
    //    LocalDate dateCreation =  LocalDate.parse(dateC, DateTimeFormatter.ISO_DATE.ISO_DATE);
 Date dateCreation = new SimpleDateFormat("dd/MM/yyyy").parse(dateC);

DonneePro donneePro = new DonneePro();
Manifestation manifestation = new Manifestation();
Soutien soutien  = new Soutien();
//DonneePro
donneePro.setAnneeThese(manifestationHolder.getAnneeThese());
donneePro.setCed(manifestationHolder.getCed());
donneePro.setDepartement(manifestationHolder.getDepartement());
donneePro.setDirecteurThese(manifestationHolder.getDirecteurThese());
donneePro.setEntiteRecherche(manifestationHolder.getEntiteRecherche());
donneePro.setEtablissement(manifestationHolder.getEtablissement());
donneePro.setFonctionnalite(manifestationHolder.getFonctionnalite());
donneePro.setGrade(manifestationHolder.getGrade());
donneePro.setRespoEntite(manifestationHolder.getRespoEntite());
donneePro.setSalarie(manifestationHolder.getSalarie());
donneePro.setType(manifestationHolder.getType());
//Manifestation

manifestation.setDateCreation(dateCreation);
manifestation.setTitreManifestation(manifestationHolder.getTitreManifestation());
manifestation.setTitreParticipation(manifestationHolder.getTitreParticipation());
manifestation.setPays(manifestationHolder.getPays());
manifestation.setVille(manifestationHolder.getVille());
manifestation.setDateDebut(manifestationHolder.getDateDebut() );
manifestation.setDateFin(manifestationHolder.getDateFin());
manifestation.setDateDepart(manifestationHolder.getDateDepart());
manifestation.setDateRetour(manifestationHolder.getDateRetour());
manifestation.setNatureParticipation(manifestationHolder.getNatureParticipation());
manifestation.setStatus(manifestationHolder.getStatus());
manifestation.setHasBenifitedTypeA(manifestationHolder.getHasBenifitedTypeA());
manifestation.setMontantAnEnCours(manifestationHolder.getMontantAnEnCours());
manifestation.setMontantAnPrd(manifestationHolder.getMontantAnPrd());

//soutien

soutien.setNature(manifestationHolder.getNature());
soutien.setMTitreTransport(manifestationHolder.getMTitreTransport());
soutien.setMHebergement(manifestationHolder.getMHebergement());
soutien.setMFraisInscription(manifestationHolder.getMFraisInscription());
soutien.setMAutre(manifestationHolder.getMAutre());
soutien.setMTotal(0);
Manifestation manifestationBD = demandeurRepository.findById(userId).map(demandeur->{
manifestation.setDemandeur(demandeur);
donneePro.setManifestation(manifestation);
//donneePro.setMissionStage(null);
manifestation.setDonneePro(donneePro);
manifestation.setSoutien(soutien);
//soutien.setMissionStage(null);
soutien.setManifestation(manifestation);
return manifestationRepository.save(manifestation);
}).orElseThrow(() -> new ResourceNotFoundException("Not found demandeur with id = " + userId));
return new ResponseEntity<>(manifestation, HttpStatus.CREATED);

}
/*@GetMapping("/manifestation/{id}")
public Manifestation findManifestationById(@PathVariable Long id) throws Exception{
return manifestationService.findManifestationById(id);
}*/


@GetMapping("/manifestation/{id}")
public ManifestationHolderResponse findManifestById(@PathVariable Long id) {
Manifestation manifestationFromDB = manifestationRepository.findById(id).orElse(null);
ManifestationHolderResponse response = new ManifestationHolderResponse();

response.setDateCreation(manifestationFromDB.getDateCreation());
response.setAnneeThese(manifestationFromDB.getDonneePro().getAnneeThese());
response.setCed(manifestationFromDB.getDonneePro().getCed());
response.setDateDebut(manifestationFromDB.getDateDebut());
response.setDateDepart(manifestationFromDB.getDateDepart());
response.setDateFin(manifestationFromDB.getDateFin());
response.setDateRetour(manifestationFromDB.getDateRetour());
response.setDepartement(manifestationFromDB.getDonneePro().getDepartement());
response.setDirecteurThese(manifestationFromDB.getDonneePro().getDirecteurThese());
response.setEmail(manifestationFromDB.getDemandeur().getEmail());
response.setEntiteRecherche(manifestationFromDB.getDonneePro().getEntiteRecherche());
response.setEtablissement(manifestationFromDB.getDonneePro().getEtablissement());
response.setFonctionnalite(manifestationFromDB.getDonneePro().getFonctionnalite());
response.setGrade(manifestationFromDB.getDonneePro().getGrade());
response.setHasBenifitedTypeA(manifestationFromDB.getHasBenifitedTypeA());
response.setMAutre(manifestationFromDB.getSoutien().getMAutre());
response.setMFraisInscription(manifestationFromDB.getSoutien().getMFraisInscription());
response.setMHebergement(manifestationFromDB.getSoutien().getMHebergement());
response.setMTitreTransport(manifestationFromDB.getSoutien().getMTitreTransport());
response.setMontantAnEnCours(manifestationFromDB.getMontantAnEnCours());

response.setMontantAnPrd(manifestationFromDB.getMontantAnPrd());
response.setNature(manifestationFromDB.getSoutien().getNature());
response.setNatureParticipation(manifestationFromDB.getNatureParticipation());
response.setNom(manifestationFromDB.getDemandeur().getNom());
response.setPays(manifestationFromDB.getPays());
response.setPrenom(manifestationFromDB.getDemandeur().getPrenom());
response.setRespoEntite(manifestationFromDB.getDonneePro().getRespoEntite());
response.setSalarie(manifestationFromDB.getDonneePro().getSalarie());
response.setTelephone(manifestationFromDB.getDemandeur().getTelephone());
response.setTitreManifestation(manifestationFromDB.getTitreManifestation());
response.setTitreParticipation(manifestationFromDB.getTitreParticipation());
response.setType(manifestationFromDB.getDonneePro().getType());
response.setVille(manifestationFromDB.getVille());
response.setSoutienId(manifestationFromDB.getSoutien().getId());
return response;

}


}
