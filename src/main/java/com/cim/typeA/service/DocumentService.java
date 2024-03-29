/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cim.typeA.service;

import com.cim.typeA.model.Document;
import java.io.IOException;
import java.util.stream.Stream;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author USER
 */
public interface DocumentService {
  Document store(String libelle, MultipartFile file) throws IOException;
Document storeDocManifestation(String libelle, MultipartFile file, Long idManifestation) throws IOException;
Document storeDocMission(String libelle, MultipartFile file, Long idMission) throws IOException;
Stream<Document> getAllDocumentsByManifestation(Long idManifestation);
Stream<Document> getAllDocumentsByMission(Long idMission);
Document getDocument(String id);
    Stream<Document> getAllDocuments();

}
