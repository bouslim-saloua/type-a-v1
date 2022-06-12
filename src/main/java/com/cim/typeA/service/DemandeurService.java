/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.Demandeur;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author HP
 */
public interface DemandeurService {
    List<Demandeur> findAll(); 
    Optional<Demandeur> findById(Long id);
}
