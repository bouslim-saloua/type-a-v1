/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.Demandeur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cim.typeA.repository.DemandeurRepository;
import com.cim.typeA.service.DemandeurService;

/**
 *
 * @author HP
 */
@Service
public class DemandeurServiceImpl implements DemandeurService{
    @Autowired
private DemandeurRepository demandeurRepository;

public void save(Demandeur demandeur){
demandeurRepository.save(demandeur);
}

public List<Demandeur> findAllSortedByDateCreation(){
return demandeurRepository.findAllSortedByDateCreation();
}



    

}
