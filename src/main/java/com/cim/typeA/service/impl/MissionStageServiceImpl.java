 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.MissionStage;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cim.typeA.repository.MissionStageRepository;
import com.cim.typeA.repository.impl.MissionStageRepositoryImpl;
import com.cim.typeA.service.MissionStageService;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author HP
 */

@RequiredArgsConstructor
@Service
public class MissionStageServiceImpl implements MissionStageService{
   final MissionStageRepositoryImpl missionStageRepositoryImpl;
    final MissionStageRepository missionStageRepository;


@Override
public MissionStage save(MissionStage missionStage) throws Exception{
MissionStage missionStageFromDB = missionStageRepository.findById(missionStage.getId()).orElse(null);
if(missionStageFromDB != null) throw new Exception("MissionStage already exists");
return missionStageRepository.save(missionStage);
}

@Override
public MissionStage update(MissionStage missionStage) throws Exception{
 
MissionStage missionStageFromDB = missionStageRepository.findById(missionStage.getId()).orElse(null);
if(missionStageFromDB == null) throw new Exception("not found");
missionStage.setId(missionStageFromDB.getId());
return missionStageRepository.save(missionStage);
}


//update
@Override
public MissionStage valider(MissionStage missionStage) throws Exception{
MissionStage missionStageFromDB = missionStageRepository.findById(missionStage.getId()).orElse(null);
if(missionStageFromDB == null ) throw new Exception("Unfound");
missionStage.setStatus("validée");
return missionStageRepository.save(missionStage);
}

//update
@Override
public MissionStage refuser(MissionStage missionStage) throws Exception{
MissionStage missionStageFromDB = missionStageRepository.findById(missionStage.getId()).orElse(null);
if(missionStageFromDB == null ) throw new Exception("Unfound");
missionStage.setStatus("refusée");
return missionStageRepository.save(missionStage);
}

@Override
public List<MissionStage> findAll(){
return missionStageRepository.findAll();
}

@Override
public List<MissionStage> findAllRefused(){
return missionStageRepository.findAllRefused();
}

@Override
public List<MissionStage> findAllAccepted(){
return missionStageRepository.findAllAccepted();
}

@Override
public List<MissionStage> findAllInProgress(){
return missionStageRepository.findAllInProgress();
}

@Override
public Long countAll(){
return missionStageRepository.countAll();
}

@Override
public Long countAllRefused(){
return missionStageRepository.countAllRefused();
}

@Override
public Long countAllAccepted(){
return missionStageRepository.countAllAccepted();
}

@Override
public Long countAllInProgress(){
return missionStageRepository.countAllInProgress();
}

@Override
public Long delete(Long id) throws Exception{

MissionStage missionStageFromDB = missionStageRepository.findById(id).orElse(null);

if(missionStageFromDB == null ) throw new Exception("missionStage not found");
missionStageRepository.delete(missionStageFromDB);
return id;

}

@Override
public List<MissionStage> findAllByDateCreation(){
return missionStageRepository.findAllByDateCreation();
}


@Override
public void exportPdfFile(Long id, OutputStream outPutStream) throws SQLException, JRException, IOException {
 JasperPrint jasperPrint =  missionStageRepositoryImpl.exportPdfFile(id);
JasperExportManager.exportReportToPdfStream(jasperPrint, outPutStream);
}

}
