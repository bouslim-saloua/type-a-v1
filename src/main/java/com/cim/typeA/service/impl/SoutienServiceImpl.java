/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.Soutien;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cim.typeA.repository.SoutienRepository;
import com.cim.typeA.service.SoutienService;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author HP
 */
@RequiredArgsConstructor
@Service
public class SoutienServiceImpl implements SoutienService{
    

final SoutienRepository soutienRepository;

@Override
 public Soutien save(Soutien soutien) throws Exception{
int mTotal = calculerTotal(soutien);
Soutien soutienFromDB = soutienRepository.findById(soutien.getId()).orElse(null);
if(soutienFromDB != null) throw new Exception("Soutien already exists");
soutien.setMTotal(mTotal);
return soutienRepository.save(soutien);

}

@Override
public Soutien update(Soutien soutien) throws Exception{
int mTotal = calculerTotal(soutien);
Soutien soutienFromDB = soutienRepository.findById(soutien.getId()).orElse(null);
if(soutienFromDB == null) throw new Exception("not found");
soutien.setId(soutienFromDB.getId());
soutien.setMTotal(mTotal);
return soutienRepository.save(soutien);
}

@Override
public int calculerTotal(Soutien soutien) throws Exception{
Soutien soutienFromDB = soutienRepository.findById(soutien.getId()).orElse(null);
if(soutienFromDB == null) throw new Exception("not found");
int mTitreTransport = soutien.getMTitreTransport();
 int mFraisInscription = soutien.getMFraisInscription();
 int mHebergement = soutien.getMHebergement();
 int mAutre = soutien.getMAutre();
int mTotal = mTitreTransport + mFraisInscription + mHebergement + mAutre;
return mTotal;
}

@Override
public int findSumTotalSoutien(){
return soutienRepository.findSumTotalSoutien();
}

@Override
    public List<Soutien> findAll(){
return soutienRepository.findAll();
}


@Override 
public Long delete(Long id) throws Exception{
Soutien soutienFromDB = soutienRepository.findById(id).orElse(null);

if(soutienFromDB == null ) throw new Exception("soutien not found");
soutienRepository.delete(soutienFromDB);
return id;
}

}
