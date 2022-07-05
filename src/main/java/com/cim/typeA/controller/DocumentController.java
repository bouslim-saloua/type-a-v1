/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller;

import com.cim.typeA.model.Document;
import com.cim.typeA.payload.response.doc.message.ResponseDocument;
import com.cim.typeA.payload.response.doc.message.ResponseMessage;
import com.cim.typeA.service.DocumentService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author USER
 */

@Api
@RequiredArgsConstructor
@RestController
@RequestMapping("api/document")
@CrossOrigin(origins={"http://localhost:3000/","http://localhost:5000/"})
public class DocumentController {

final DocumentService documentService;

@PostMapping("/upload")
public ResponseEntity<ResponseMessage> uploadFile(@RequestParam String libelle, @RequestPart("file") MultipartFile file){
String message= "";
try{
documentService.store(libelle, file);
message = "Document uploaded successfully : " + file.getOriginalFilename();
return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
}catch(Exception e){
message = "Could not upload the file: " + file.getOriginalFilename() + " !";
return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
}
}

@GetMapping("/documents")
public ResponseEntity<List<ResponseDocument>> getListDocuments(){
List<ResponseDocument> documents = documentService.getAllDocuments().map(dbDocument -> {
String documentDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/documents/").path(dbDocument.getId()).toUriString();

return new ResponseDocument(
dbDocument.getLibelle(), dbDocument.getNom(),documentDownloadUri, dbDocument.getType(), dbDocument.getData().length);
}).collect(Collectors.toList());
return ResponseEntity.status(HttpStatus.OK).body(documents);
}

@GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> getDocument(@PathVariable String id){
    Document document  = documentService.getDocument(id);
return ResponseEntity.ok()
.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ document.getNom()+"\"")
.body(document.getData());
}
}
