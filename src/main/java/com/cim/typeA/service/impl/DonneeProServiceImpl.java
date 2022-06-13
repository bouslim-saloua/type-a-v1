/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.DonneePro;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cim.typeA.repository.DonneeProRepository;
import com.cim.typeA.service.DonneeProService;
import lombok.AllArgsConstructor;

/**
 *
 * @author HP
 */

@Service
@AllArgsConstructor
public class DonneeProServiceImpl implements DonneeProService {


final DonneeProRepository donneeProRepository;

@Override
public DonneePro save(DonneePro donneePro) throws Exception{
DonneePro donneeProFromDB = donneeProRepository.findById(donneePro.getId()).orElse(null);
if(donneeProFromDB != null) throw new Exception("DonneePro already exists");
donneePro.setManifestation(donneePro.getManifestation());
donneePro.setMissionStage(donneePro.getMissionStage());
return donneeProRepository.save(donneePro);
}

public DonneePro update(DonneePro donneePro) throws Exception{
 
DonneePro donneeProFromDB = donneeProRepository.findById(donneePro.getId()).orElse(null);
if(donneeProFromDB == null) throw new Exception("Not found");
donneePro.setId(donneeProFromDB.getId());
return donneeProRepository.save(donneePro);
}

@Override
public List<DonneePro> findAll(){
return donneeProRepository.findAll();
}

@Override
public Long delete(Long id) throws Exception{

DonneePro donneeProFromDB = donneeProRepository.findById(id).orElse(null);

if(donneeProFromDB == null ) throw new Exception("donneePro not found");
donneeProRepository.delete(donneeProFromDB);
return id;
}
    
}
