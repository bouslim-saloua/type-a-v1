/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author USER
 */
@Data
@Entity
public class Document implements Serializable{
   @Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name= "uuid", strategy="uuid2") 
private String id;
private String libelle;
private String nom; 
private String type;
@Lob
private byte[] data;

@ManyToOne
    @JoinColumn(name="manifestation_id", nullable=true)
private Manifestation manifestation;

@ManyToOne
    @JoinColumn(name="mission_id", nullable=true)
private MissionStage mission;

public Document(String libelle, String nom, String type, byte[] data){
this.libelle   = libelle;
this.nom = nom;
this.type = type;
this.data = data;
}
}
