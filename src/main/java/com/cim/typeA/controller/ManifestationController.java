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
import com.cim.typeA.repository.DemandeurRepository;
import com.cim.typeA.repository.ManifestationRepository;
import com.cim.typeA.service.ManifestationService;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
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
@CrossOrigin("http://localhost:3000/")
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
@PutMapping("/valider")
public ResponseEntity<?> valider( @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.valider(manifestation));
}

@PutMapping("/refuser")
public ResponseEntity<?> refuser( @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.refuser(manifestation));
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
/*@PostMapping("/id/{idManifestation}")
public void export(ModelAndView model, HttpServletResponse response, @PathVariable Long idManifestation) throws IOException, JRException, SQLException {
    JasperPrint jasperPrint = null;
response.setContentType("application/x-download");
response.setHeader("Content-Disposition", String.format("attachement; fileName=\"manifestation.pdf\"" ));
    OutputStream out = response.getOutputStream();
jasperPrint = manifestationService.exportPdfFile(idManifestation);
    JasperExportManager.exportReportToPdfStream(jasperPrint, out);
}*/

/*@PostMapping("/id/{idManifestation}")
public void exportPdfFile(HttpServletResponse response, @PathVariable Long idManifestation) throws SQLException, JRException, IOException{
manifestationService.exportPdfFile(response, idManifestation);
}*/

 @GetMapping("/id/{id}")
 public void generateReport(@PathVariable Long id, HttpServletResponse response) throws IOException, JRException, SQLException {
response.setContentType("application/x-download");

 response.setHeader("Content-Disposition", String.format("attachment; filename=\"manifestation.pdf\""));
OutputStream out = response.getOutputStream();
manifestationService.exportPdfFile(id, out);
}

/*@GetMapping("/History")
public ResponseEntity<?> findAllByDateCreation(){
return ResponseEntity.ok().body(manifestationService.findAllByDateCreation());
}*/

@GetMapping("/manifestationsByUser/{utilisateurId}")
public List<Manifestation> findAllByUtilisateurId(@PathVariable Long utilisateurId){
return manifestationService.findAllByUtilisateurId(utilisateurId);
}

/*@PostMapping("/{userId}/{manifestation}")
public ResponseEntity<?> addManifestation(@PathVariable Long userId, @RequestBody Manifestation manifestation){
    //Utilisateur utilisateurById = utilisateurRepository.findById(utilisateurPostDto.getId()).orElse(null);

Manifestation manifestationBD = demandeurRepository.findById(userId).map(demandeur->{
manifestation.setDemandeur(demandeur);
return manifestationRepository.save(manifestation);
}).orElseThrow(() -> new ResourceNotFoundException("Not found demandeur with id = " + userId));
return new ResponseEntity<>(manifestation, HttpStatus.CREATED);

}*/

//another try
@PostMapping("/{userId}/")
public ResponseEntity<?> addManifestation(@PathVariable Long userId,  @RequestBody ManifestationHolder manifestationHolder) {
//return ResponseEntity.ok().body(manifestationService.addManifestation(userId, donneePro, manifestation, soutien));

/*
Demandeur demandeur = demandeurRepository.findById(userId).orElse(null);
if(demandeur == null) throw new Exception("User doesn't exist");

//***Demandeur foreign keys
//for manifestation:
demandeur.getManifestations().forEach((manifest) ->{
manifest.setDemandeur(demandeur);
});
//for MissionStage
demandeur.getMissions().forEach((missionStage) -> {
missionStage.setDemandeur(demandeur);
});
//for DonneePro
demandeur.getDonneePros().forEach((donneeP) ->{
donneeP.setDemandeur(demandeur);
});
donneePro.setDemandeur(demandeur);

manifestation.setDemandeur(demandeur);

manifestation.setSoutien(soutien);

soutien.setManifestation(manifestation);

return manifestationRepository.save(manifestation);

*/
Manifestation manifestation = manifestationHolder.getManifestation();
DonneePro donneePro = manifestationHolder.getDonneePro();
Soutien soutien = manifestationHolder.getSoutien();
Manifestation manifestationBD = demandeurRepository.findById(userId).map(demandeur->{
manifestation.setDemandeur(demandeur);
donneePro.setDemandeur(demandeur);
soutien.setManifestation(manifestation);
manifestation.setSoutien(soutien);
return manifestationRepository.save(manifestation);
}).orElseThrow(() -> new ResourceNotFoundException("Not found demandeur with id = " + userId));
return new ResponseEntity<>(manifestation, HttpStatus.CREATED);
}


}
