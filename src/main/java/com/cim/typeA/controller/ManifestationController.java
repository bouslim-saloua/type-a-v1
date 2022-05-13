/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.Manifestation;
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
@RestController
@RequestMapping("api/manifestation")
@AllArgsConstructor
public class ManifestationController {

final ManifestationService manifestationService;


@PostMapping("/")
public ResponseEntity<?> save(@Valid @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.status(HttpStatus.CREATED).body(manifestationService.save(manifestation));
}

@PutMapping("/update")
public ResponseEntity<?> update(@Valid @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.update(manifestation));
}


//update
@PutMapping("/valider")
public ResponseEntity<?> valider(@Valid @RequestBody Manifestation manifestation) throws Exception{
if(manifestation == null) return ResponseEntity.badRequest().body("La manifestation fourni n'est pas valide");
return ResponseEntity.ok().body(manifestationService.valider(manifestation));
}

@PutMapping("/refuser")
public ResponseEntity<?> refuser(@Valid @RequestBody Manifestation manifestation) throws Exception{
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

@GetMapping("/History")
public ResponseEntity<?> findAllByDateCreation(){
return ResponseEntity.ok().body(manifestationService.findAllByDateCreation());
}
}
