/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.payload.response.doc.message;

import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class ResponseDocument {
private String libelle;
    private String nom; 
private String url;
private String type;
private Long size;

public ResponseDocument(String libelle, String nom, String url, String type, long size){
this.libelle = libelle;
this.nom = nom;
this.url = url;
this.type = type;
this.size = size;
}
}
