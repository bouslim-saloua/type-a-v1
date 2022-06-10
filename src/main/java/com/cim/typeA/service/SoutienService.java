/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.Soutien;
import com.cim.typeA.model.Utilisateur;
import com.cim.typeA.model.DonneePro;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.model.MissionStage;
import java.util.List;
/**
 *
 * @author HP
 */
public interface SoutienService {
    Soutien save(Soutien soutien) throws Exception;
Soutien update(Soutien soutien) throws Exception;
int calculerTotal(Soutien soutien) throws Exception;
int findSumTotalSoutien();
    List<Soutien> findAll();
Long delete(Long id) throws Exception;

Soutien addSoutienManifestation(Utilisateur utilisateur, DonneePro donneePro, Manifestation manifestation, Soutien soutien);

Soutien addSoutienMission(Utilisateur utilisateur, DonneePro donneePro, MissionStage missionStage, Soutien soutien);


}
