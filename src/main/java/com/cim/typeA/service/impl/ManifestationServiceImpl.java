/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;



import com.cim.typeA.config.WebConfig;
import com.cim.typeA.model.Manifestation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.stereotype.Service;

import com.cim.typeA.repository.ManifestationRepository;
import com.cim.typeA.repository.impl.ManifestationRepositoryImpl;
import com.cim.typeA.service.ManifestationService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;


import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author HP
 */

@RequiredArgsConstructor
@Service
public class ManifestationServiceImpl implements ManifestationService {


final ManifestationRepositoryImpl manifestationRepositoryImpl;
final ManifestationRepository manifestationRepository;
@Qualifier("jdbcTemplate")
private JdbcTemplate jdbcTemplate;

@Autowired
private ResourceLoader resourceLoader;


@Override
public Manifestation save(Manifestation manifestation) throws Exception{
Manifestation manifestationFromDB = manifestationRepository.findById(manifestation.getId()).orElse(null);
if(manifestationFromDB != null) throw new Exception("Manifestation already exists");
manifestation.setDemandeur(manifestation.getDemandeur());
return manifestationRepository.save(manifestation);
}

@Override
public Manifestation update(Manifestation manifestation) throws Exception{
 
Manifestation manifestationFromDB = manifestationRepository.findById(manifestation.getId()).orElse(null);
if(manifestationFromDB == null) throw new Exception("User not found");
manifestation.setId(manifestationFromDB.getId());
return manifestationRepository.save(manifestation);
}


//update
@Override
public Manifestation valider(Manifestation manifestation) throws Exception{
Manifestation manifestationFromDB = manifestationRepository.findById(manifestation.getId()).orElse(null);
if(manifestationFromDB == null ) throw new Exception("Unfound");
manifestation.setStatus("validée");
return manifestationRepository.save(manifestation);
}

//update
@Override
public Manifestation refuser(Manifestation manifestation) throws Exception{
Manifestation manifestationFromDB = manifestationRepository.findById(manifestation.getId()).orElse(null);
if(manifestationFromDB == null ) throw new Exception("Unfound");
manifestation.setStatus("refusée");
return manifestationRepository.save(manifestation);
}

@Override
public List<Manifestation> findAll(){
return manifestationRepository.findAll();
}

@Override
public List<Manifestation> findAllRefused(){
return manifestationRepository.findAllRefused();
}

@Override
public List<Manifestation> findAllAccepted(){
return manifestationRepository.findAllAccepted();
}

@Override
public List<Manifestation> findAllInProgress(){
return manifestationRepository.findAllInProgress();
}

@Override
public Long countAll(){
return manifestationRepository.countAll();
}

@Override
public Long countAllRefused(){
return manifestationRepository.countAllRefused();
}

@Override
public Long countAllAccepted(){
return manifestationRepository.countAllAccepted();
}

@Override
public Long countAllInProgress(){
return manifestationRepository.countAllInProgress();
}

@Override
public Long delete(Long id) throws Exception{

Manifestation manifestationFromDB = manifestationRepository.findById(id).orElse(null);

if(manifestationFromDB == null ) throw new Exception("manifestation not found");
manifestationRepository.delete(manifestationFromDB);
return id;

}

/*@Override
public List<Manifestation> findAllByDateCreation(){
return manifestationRepository.findAllByDateCreation();
}
*/

@Override
public void exportPdfFile(Long id, OutputStream outPutStream) throws SQLException, JRException, IOException {
 JasperPrint jasperPrint =  manifestationRepositoryImpl.exportPdfFile(id);
JasperExportManager.exportReportToPdfStream(jasperPrint, outPutStream);
}

@Override
public List<Manifestation> findAllByUtilisateurId(Long utilisateurId){
return manifestationRepository.findAllByUtilisateurId(utilisateurId);
}




}
