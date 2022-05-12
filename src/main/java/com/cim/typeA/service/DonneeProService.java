/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.DonneePro;
import java.util.List;

/**
 *
 * @author HP
 */
public interface DonneeProService {
    DonneePro save(DonneePro donneePro) throws Exception;
Long delete(Long id) throws Exception;
DonneePro update(DonneePro donneePro) throws Exception;
    List<DonneePro> findAll();


}
