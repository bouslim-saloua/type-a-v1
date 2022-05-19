/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.converter.impl.UtilisateurGetDtoConverter;
import com.cim.typeA.converter.impl.UtilisateurPostConverter;
import com.cim.typeA.dto.UtilisateurGetDto;
import com.cim.typeA.dto.UtilisateurPostDto;

/*import com.cim.typeA.model.Utilisateur;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;*/


import com.cim.typeA.model.Utilisateur;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.cim.typeA.repository.UtilisateurRepository;
import com.cim.typeA.service.UtilisateurService;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author HP
 */

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

//final  MapStructMapper mapStructMapper;
 final UtilisateurRepository utilisateurRepository;
final UtilisateurPostConverter utilisateurPostConverter;
final UtilisateurGetDtoConverter utilisateurGetDtoConverter;

/*public UtilisateurServiceImpl(MapStructMapper mapStructMapper, UtilisateurRepository utilisateurRepository){
this.mapStructMapper = mapStructMapper;
this.utilisateurRepository = utilisateurRepository;
}*/



/*
** Contrainte sur email,
** Contrainte sur telephone;
** Contrainte sur id
*/
@Override
public Utilisateur save(UtilisateurPostDto utilisateurPostDto) throws Exception{

Utilisateur utilisateurById = utilisateurRepository.findById(utilisateurPostDto.getId()).orElse(null);

Utilisateur utilisateurByEmail = utilisateurRepository.findByEmail(utilisateurPostDto.getEmail());

Utilisateur utilisateurByTelephone = utilisateurRepository.findByTelephone(utilisateurPostDto.getTelephone());
if(utilisateurById != null || utilisateurByEmail != null || utilisateurByTelephone != null) throw new Exception("User already exists");
return utilisateurRepository.save(utilisateurPostConverter.convertToDM(utilisateurPostDto));  

}

@Override
public Utilisateur update(UtilisateurPostDto utilisateurPostDto) throws Exception{

 
Utilisateur utilisateurFromDB = utilisateurRepository.findById(utilisateurPostDto.getId()).orElse(null);
if(utilisateurFromDB == null) throw new Exception("User not found");
utilisateurPostDto.setId(utilisateurFromDB.getId());
return utilisateurRepository.save(utilisateurPostConverter.convertToDM(utilisateurPostDto));

}

@Override
public UtilisateurGetDto findByEmail(String email){
return utilisateurGetDtoConverter.convertToDTO(utilisateurRepository.findByEmail(email));
}

@Override
public UtilisateurGetDto findByTelephone(String telephone){
return utilisateurGetDtoConverter.convertToDTO(utilisateurRepository.findByTelephone(telephone));}

@Override
public List<UtilisateurGetDto> findAll(){
return utilisateurGetDtoConverter.convertToDTOs(utilisateurRepository.findAll());
}

@Override
public Long delete(Long id) throws Exception{
Utilisateur utilisateurFromDB = utilisateurRepository.findById(id).orElse(null);

if(utilisateurFromDB == null ) throw new Exception("User not found");
utilisateurRepository.delete(utilisateurFromDB);
return id;
}

//POST
@Override
public UtilisateurGetDto signIn(UtilisateurPostDto utilisateurPostDto) throws Exception{
Utilisateur utilisateurFromDB = utilisateurRepository.findByEmail(utilisateurPostDto.getEmail());
if(utilisateurFromDB == null) throw new Exception("User Not  found");

else if(!(utilisateurFromDB.getPassword()).equals(utilisateurPostDto.getPassword())) throw new Exception("Passwords don't match !!");


//Mais normalement je ne dois pas retourner l'objet utilisateur mais je dois retouner son dto
else return utilisateurGetDtoConverter.convertToDTO(utilisateurFromDB);
}

//POST
@Override
public UtilisateurGetDto signUp(UtilisateurPostDto utilisateurPostDto) throws Exception{

return utilisateurGetDtoConverter.convertToDTO(utilisateurRepository.save(utilisateurPostConverter.convertToDM(utilisateurPostDto)));
}


//field
//setter
//constructor //injection de dépendance


/////Export format PDF
@Override
 public String exportReport() throws FileNotFoundException, JRException{
List<Utilisateur> users = utilisateurRepository.findAll();
File file = ResourceUtils.getFile("classpath:Users.jrxml");
     JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
     Map<String, Object> params = new HashMap<>();
params.put("createdBy ", "saloua");
     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

///Exporting file as pdf
JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\HP\\Desktop");

return "fileGenerated Successfully";
}



}
