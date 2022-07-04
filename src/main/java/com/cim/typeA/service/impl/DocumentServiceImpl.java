/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.service.impl;

import com.cim.typeA.model.Document;
import com.cim.typeA.repository.DocumentRepository;
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
}
