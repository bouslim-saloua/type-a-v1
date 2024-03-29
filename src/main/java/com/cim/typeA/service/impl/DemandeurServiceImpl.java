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
import java.util.Optional;

/**
 *
 * @author HP
 */
@Service
public class DemandeurServiceImpl implements DemandeurService{
    @Autowired
private DemandeurRepository demandeurRepository;

public Demandeur save(Demandeur demandeur){
demandeur.getManifestations().forEach((manifestation)->{
manifestation.setDemandeur(demandeur);
});
return demandeurRepository.save(demandeur);
}

public List<Demandeur> findAllSortedByDateCreation(){
return demandeurRepository.findAllSortedByDateCreation();
}

@Override
public List<Demandeur> findAll(){
return demandeurRepository.findAll();
}
@Override
public Optional<Demandeur> findById(Long id){
return demandeurRepository.findById(id);
}
    

}
