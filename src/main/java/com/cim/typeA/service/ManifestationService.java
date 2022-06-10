/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.Manifestation;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
public interface ManifestationService {
Manifestation save(Manifestation manifestation) throws Exception;

 Manifestation valider(Manifestation manifestation) throws Exception;

Manifestation refuser(Manifestation manifestation) throws Exception;

Manifestation update(Manifestation manifestation) throws Exception;
Long delete(Long id) throws Exception;
List<Manifestation> findAll();
List<Manifestation> findAllRefused();

List<Manifestation> findAllAccepted();

List<Manifestation> findAllInProgress();
Long countAll();

Long countAllRefused();

 Long countAllAccepted();
Long countAllInProgress();
//ResponseEntity<byte[]> getReport(Long idManifestation) ;
//void getReport(Long id) throws JRException, SQLException;
void exportPdfFile(Long id, OutputStream outPutStream) throws SQLException, JRException, IOException;
// List<Manifestation> findAllByDateCreation();
//String generateReport(Long idManifestation);
//JasperPrint exportPdfFile(Long idManifestation) throws SQLException, JRException, IOException;
//void exportPdfFile(HttpServletResponse response, Long idManifestation) throws SQLException, JRException, IOException;
List<Manifestation> findAllByUtilisateurId(Long utilisateurId);

Manifestation addManifestation(Manifestation manifestation);
}
