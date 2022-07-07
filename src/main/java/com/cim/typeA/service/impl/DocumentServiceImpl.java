/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.Document;
import com.cim.typeA.model.Manifestation;
import com.cim.typeA.model.MissionStage;
import com.cim.typeA.repository.DocumentRepository;
import com.cim.typeA.repository.ManifestationRepository;
import com.cim.typeA.repository.MissionStageRepository;
import com.cim.typeA.service.DocumentService;
import java.io.IOException;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author USER
 */
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
    final DocumentRepository documentRepository;
final ManifestationRepository manifestationRepository;
final MissionStageRepository missionRepository;
@Override
 public Document store(String libelle, MultipartFile file) throws IOException{
String documentName = StringUtils.cleanPath(file.getOriginalFilename());
Document documentDb = new Document(libelle, documentName, file.getContentType(), file.getBytes());

return documentRepository.save(documentDb);
}

@Override
public Document getDocument(String id){
return documentRepository.findById(id).get();
}

@Override
 public Stream<Document> getAllDocuments(){
return documentRepository.findAll().stream();
}

@Override
public Document storeDocManifestation(String libelle, MultipartFile file, Long idManifestation) throws IOException{
String documentName = StringUtils.cleanPath(file.getOriginalFilename());
Document documentDb = new Document(libelle, documentName, file.getContentType(), file.getBytes());
    Manifestation manifestationDB = manifestationRepository.findById(idManifestation).orElse(null);
documentDb.setManifestation(manifestationDB);
return documentRepository.save(documentDb);
}

@Override
public Document storeDocMission(String libelle, MultipartFile file, Long idMission) throws IOException{
String documentName = StringUtils.cleanPath(file.getOriginalFilename());
Document documentDb = new Document(libelle, documentName, file.getContentType(), file.getBytes());
    MissionStage missionDB = missionRepository.findById(idMission).orElse(null);
documentDb.setMission(missionDB);
return documentRepository.save(documentDb);
}

@Override
public Stream<Document> getAllDocumentsByManifestation(Long idManifestation){
return documentRepository.findAllDocumentsByManifestation(idManifestation).stream();
}

}
