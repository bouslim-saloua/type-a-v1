/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.dto.UtilisateurGetDto;
import com.cim.typeA.dto.UtilisateurPostDto;
import com.cim.typeA.model.Utilisateur;
import java.io.FileNotFoundException;
import java.util.List;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author HP
 */
public interface UtilisateurService {

Utilisateur save(UtilisateurPostDto utilisateurPostDto) throws Exception;
Utilisateur update(UtilisateurPostDto utilisateurPostDto) throws Exception;
UtilisateurGetDto findByEmail(String email);
Long delete(Long id) throws Exception;
    UtilisateurGetDto signIn(UtilisateurPostDto utilisateurPostDto) throws Exception;
UtilisateurGetDto signUp(UtilisateurPostDto utilisateurPostDto) throws Exception;
UtilisateurGetDto findByTelephone(String telephone);
    List<UtilisateurGetDto> findAll();
String exportReport() throws FileNotFoundException, JRException;

    
}
