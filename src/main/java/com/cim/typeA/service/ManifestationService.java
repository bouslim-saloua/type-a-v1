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
import com.cim.typeA.model.*;
import com.cim.typeA.payload.holder.ManifestationHolderResponse;
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

 Manifestation valider(Long id) throws Exception;

Manifestation refuser(Long id) throws Exception;

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
public Manifestation findManifestationById(Long id) throws Exception;
List<Manifestation> findAllByUtilisateurId(Long utilisateurId) throws Exception;

//Manifestation addManifestation(Long userId, DonneePro donneePro, Manifestation manifestation, Soutien soutien) throws Exception;
}
